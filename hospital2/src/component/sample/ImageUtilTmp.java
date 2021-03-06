package component.sample;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JComponent;

public class ImageUtilTmp {
	public static Image getImageFromStream(InputStream is) throws IOException {
		return ImageIO.read(is);
	}

	public static Image getImageFromBytes(byte[] is) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(is);
		return ImageIO.read(bais);
	}

	public static Image scaleImage(Image img, JComponent comp) {
		return img.getScaledInstance(comp.getWidth(), comp.getHeight(),
				Image.SCALE_SMOOTH);
	}

	public static byte[] getImageBytes(BufferedImage bufImage) {
		try {
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			javax.imageio.ImageIO.write(bufImage, "png", baos);
			return baos.toByteArray();
		} catch (IOException ex) {
			Logger.getLogger("global").log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static BufferedImage getTransparentImageRemoveNoise(BufferedImage img, Color clr) throws IOException {
		BufferedImage b = getTransparentImage(img, clr);
		com.jhlabs.image.MedianFilter m = new com.jhlabs.image.MedianFilter();
		return m.filter(b, null);
	}
	
	public static BufferedImage getTransparentImage(BufferedImage img, Color clr)
			throws IOException {
		BufferedImage dimg = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		dimg.setAccelerationPriority(1);
		Graphics2D g = dimg.createGraphics();
		g.setComposite(AlphaComposite.Src);
		g.drawImage(img, null, 0, 0);
		g.dispose();
		int rgb = clr.getRGB();
		for (int i = 0; i < dimg.getHeight(); i++) {
			for (int j = 0; j < dimg.getWidth(); j++) {
				if (dimg.getRGB(j, i) == rgb) {
					dimg.setRGB(j, i, 0x8F1C1C);
				}
			}
		}
		img.flush();
		return dimg;
//		return createCompressedImage(dimg);
	}

	public static void transparentDarkPixel(BufferedImage img, Color dark, int value) {
		int newVal = value * 25;
		int blue = dark.getBlue() + newVal;
		int red = dark.getRed() + newVal;
		int green = dark.getGreen() + newVal;
		for (int i = 0; i < img.getHeight(); i++) {
			for (int j = 0; j < img.getWidth(); j++) {
				// need to create a class that is same as color to get the value
				// of RGB
				int pixelCol = img.getRGB(j, i);
				if (getBlue(pixelCol) <= blue && getRed(pixelCol) <= red
						&& getGreen(pixelCol) <= green) {
					img.setRGB(j, i, 0x8F1C1C);
				}
			}
		}
	}

	public static void transparentDarkPixel(BufferedImage img, int value) {
		transparentDarkPixel(img, Color.BLACK, value);
	}

	public static int getRed(int pixelCol) {
		return (pixelCol >>> 16) & 0xff;
	}

	public static int getBlue(int pixelCol) {
		return pixelCol & 0xff;
	}

	public static int getGreen(int pixelCol) {
		return (pixelCol >>> 8) & 0xff;
	}

	public static int getAlpha(int pixelCol) {
		return (pixelCol >>> 24) & 0xff;
	}

	public static BufferedImage copy(BufferedImage im) {
		int w = im.getWidth();
		int h = im.getHeight();
		int type = im.getType();
		if (type == BufferedImage.TYPE_CUSTOM) {
			System.out.println("note: not preserving type");
			type = im.getColorModel().hasAlpha() ? BufferedImage.TYPE_INT_ARGB
					: BufferedImage.TYPE_INT_RGB;
		}
		BufferedImage result = new BufferedImage(w, h, type);

		Graphics2D g = result.createGraphics();
		g.drawRenderedImage(im, null);
		g.dispose();
		return result;
	}

	public static BufferedImage createCompressedImage(BufferedImage image,
			double d) {
		byte[] bytes = ImageKit.getBytes(image, (float) (d / 100));
		// numBytes = bytes.length;
		System.out.println("NEW SIZE = " + bytes.length);
		BufferedImage img = ImageKit.read(bytes);
		image.flush();
		image = null;
		img.flush();
		return img;
	}

	public static BufferedImage createCompressedImage(BufferedImage image) {
		return createCompressedImage(image, 100);
	}

	protected static class ImageKit {
		// quality means jpeg output, if quality is < 0 ==> use default quality
		private static void write(BufferedImage image, float quality,
				OutputStream out) throws IOException {
			Iterator writers = ImageIO.getImageWritersBySuffix("jpeg");
			if (!writers.hasNext())
				throw new IllegalStateException("No writers found");
			ImageWriter writer = (ImageWriter) writers.next();
			ImageOutputStream ios = ImageIO.createImageOutputStream(out);
			writer.setOutput(ios);
			ImageWriteParam param = writer.getDefaultWriteParam();
			if (quality >= 0) {
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(quality);
			}
			writer.write(null, new IIOImage(image, null, null), param);
		}

		private static BufferedImage read(byte[] bytes) {
			try {
				return ImageIO.read(new ByteArrayInputStream(bytes));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private static byte[] getBytes(BufferedImage image, float quality) {
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream(50000);
				write(image, quality, out);
				return out.toByteArray();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private static BufferedImage compress(BufferedImage image, float quality) {
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream(50000);
				write(image, quality, out);
				byte[] b = out.toByteArray();
				ByteArrayInputStream bais = new ByteArrayInputStream(b);
				System.out.println("NEW SIZE = " + b.length);
				return ImageIO.read(bais);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public static class BufferedImageSerializer {
		int width;
		int height;
		int type;
		byte[] b;
		public BufferedImage orig;
		public BufferedImage copy;

		public BufferedImageSerializer(BufferedImage buf) {
			this.orig = buf;
			width = buf.getWidth();
			height = buf.getHeight();
			type = buf.getType();
			if (type == BufferedImage.TYPE_CUSTOM) {
				type = buf.getColorModel().hasAlpha() ? BufferedImage.TYPE_INT_ARGB
						: BufferedImage.TYPE_INT_RGB;
			}
			b = compress(getImageBytes(buf));
		}

		public BufferedImage getCopy() {
			try {
				if (copy==null) {
					copy = (BufferedImage) getImageFromBytes(deCompress(b));
				}
				return copy;
			}
			catch (Exception e) {
				return null;
			}
		}
		
		private byte[] compress(byte[] b) {
			Deflater compressor = new Deflater();
			compressor.setLevel(Deflater.BEST_COMPRESSION);

			// Give the compressor the data to compress
			compressor.setInput(b);
			compressor.finish();

			// Create an expandable byte array to hold the compressed data.
			// It is not necessary that the compressed data will be smaller than
			// the uncompressed data.
			ByteArrayOutputStream bos = new ByteArrayOutputStream(b.length);

			// Compress the data
			byte[] buf = new byte[1024];
			while (!compressor.finished()) {
				int count = compressor.deflate(buf);
				bos.write(buf, 0, count);
			}
			try {
				bos.close();
			} catch (IOException e) {
			}

			// Get the compressed data
			return bos.toByteArray();
		}

		private byte[] deCompress(byte[] b) {
			Inflater decompressor = new Inflater();
			byte[] buf = new byte[1024];
			decompressor.setInput(b);

			// Create an expandable byte array to hold the decompressed data
			ByteArrayOutputStream bos = new ByteArrayOutputStream(b.length);
			// Decompress the data
			buf = new byte[1024];
			while (!decompressor.finished()) {
				try {
					int count = decompressor.inflate(buf);
					bos.write(buf, 0, count);
				} catch (DataFormatException e) {
				}
			}
			try {
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Get the decompressed data
			return bos.toByteArray();
		}
		
		public void flushme() {
			b = null;
		}
	}
}
