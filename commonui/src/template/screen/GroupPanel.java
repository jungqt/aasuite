/*
 * NewJPanel.java
 *
 * Created on September 6, 2008, 11:11 AM
 */

package template.screen;

import bean.admin.AppConfig;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import util.BeanUtil;

/**
 *
 * @author  Entokwaa
 */
public class GroupPanel extends javax.swing.JPanel {
    int usedColor = 1;
    public static final int BLUE = 1;
    public static final int RED = 2;
    public static final int GREY = 3;
    public static final int GREEN = 4;
    
    static Color defaultColor = new java.awt.Color(0, 102, 255);
    static Color redColor = new java.awt.Color(153,0,51);
    static Color greyColor = new java.awt.Color(204,204,204);
    static Color greenColor = new java.awt.Color(0,102,102);

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (constants.Constants.panelBackground!=null) {
            if (pnlHeadLabel!=null) pnlHeadLabel.setBackground(constants.Constants.panelBackground);
            if (pnlHeader!=null) pnlHeader.setBackground(constants.Constants.panelBackground);
            if (pnlHideShow!=null) pnlHideShow.setBackground(constants.Constants.panelBackground);
            if (pnlMain!=null) pnlMain.setBackground(constants.Constants.panelBackground);
        }
    }
    
    public void noneCollapsible() {
        lblHide.setVisible(false);
        lblShow.setVisible(false);
    }
    
    public static Color getColorSelection(int color) {
        switch(color) {
            case 1: 
                return defaultColor;
            case 2: 
                return redColor;
            case 3: 
                return greyColor;
            case 4: 
                return greenColor;
        }
        return defaultColor;
    }
    
    private Color getColor() {
        return getColorSelection(usedColor);
    }
    
    public static GroupPanel construct(String name, JPanel newPanel, int usedColor) {
        GroupPanel pnl = new GroupPanel(usedColor);
        pnl.lblGroupName.setText(name);
        pnl.pnlMain.add(newPanel);
        if (AppConfig.isGroupWithTitle()) {
            pnl.pnlMain.setBorder(javax.swing.BorderFactory.createTitledBorder(BeanUtil.concat(name,":")));
            pnl.setBorder(null);
            pnl.pnlHeader.setVisible(false);
            TitledBorder b = (TitledBorder) pnl.pnlMain.getBorder();
            if (constants.Constants.labelColor!=null) {
                b.setTitleColor(constants.Constants.labelColor);
            }
        }
        if (constants.Constants.panelBackground!=null) {
            pnl.setBackground(constants.Constants.panelBackground);
            if (newPanel!=null) newPanel.setBackground(constants.Constants.panelBackground);
        }
        return pnl;
    }
    
    /** Creates new form NewJPanel */
    public GroupPanel(int usedColor) {
        this.usedColor = usedColor;
        initComponents();
        lblHide.setVisible(true);
        lblShow.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        pnlHideShow = new javax.swing.JPanel();
        lblHide = new javax.swing.JLabel();
        lblShow = new javax.swing.JLabel();
        pnlHeadLabel = new javax.swing.JPanel();
        lblGroupName = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();

        setBorder(new javax.swing.border.LineBorder(getColor(), 1, true));
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(getColor());
        pnlHeader.setLayout(new java.awt.BorderLayout());

        pnlHideShow.setBackground(getColor());
        pnlHideShow.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblHide.setFont(new java.awt.Font("Tahoma", 0, 10));
        lblHide.setForeground(new java.awt.Color(255, 255, 255));
        lblHide.setText("Hide");
        lblHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHideMouseClicked(evt);
            }
        });
        pnlHideShow.add(lblHide);

        lblShow.setFont(new java.awt.Font("Tahoma", 0, 10));
        lblShow.setForeground(new java.awt.Color(255, 255, 255));
        lblShow.setText("Show");
        lblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowMouseClicked(evt);
            }
        });
        pnlHideShow.add(lblShow);

        pnlHeader.add(pnlHideShow, java.awt.BorderLayout.EAST);

        pnlHeadLabel.setBackground(getColor());
        pnlHeadLabel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblGroupName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGroupName.setForeground(new java.awt.Color(255, 255, 255));
        lblGroupName.setText("Department");
        pnlHeadLabel.add(lblGroupName);

        pnlHeader.add(pnlHeadLabel, java.awt.BorderLayout.WEST);

        add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlMain.setLayout(new java.awt.GridLayout(1, 0));
        add(pnlMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void lblHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHideMouseClicked
    hide();
}//GEN-LAST:event_lblHideMouseClicked

private void lblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMouseClicked
    show();    
}//GEN-LAST:event_lblShowMouseClicked

    @Override
public void show() {
    pnlMain.setVisible(true);
    lblHide.setVisible(true);
    lblShow.setVisible(false);    
}

    @Override
public void hide() {
    if (AppConfig.isGroupWithTitle()) {
//        no hiding when group title is use
        return;
    }
    pnlMain.setVisible(false);
    lblHide.setVisible(false);
    lblShow.setVisible(true);
}

    public void setVisible(boolean b) {
    	if (b) show();
    	else hide();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblGroupName;
    private javax.swing.JLabel lblHide;
    private javax.swing.JLabel lblShow;
    private javax.swing.JPanel pnlHeadLabel;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHideShow;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

}
