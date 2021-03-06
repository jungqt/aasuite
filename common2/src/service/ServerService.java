
package service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1-04/12/2007 02:26 PM(vivekp)-RC1
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ServerService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8084/school2Service/WSServer?wsdl")
public class ServerService
    extends Service
{

    private final static URL SERVERSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8084/school2Service/WSServer?wsdl");
        } catch (MalformedURLException e) {
			Logger.getLogger("global").log(Level.SEVERE, null, e);
        }
        SERVERSERVICE_WSDL_LOCATION = url;
    }

    public ServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServerService() {
        super(SERVERSERVICE_WSDL_LOCATION, new QName("http://service/", "ServerService"));
    }

    /**
     * 
     * @return
     *     returns Server
     */
    @WebEndpoint(name = "ServerPort")
    public Server getServerPort() {
        return (Server)super.getPort(new QName("http://service/", "ServerPort"), Server.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Server
     */
    @WebEndpoint(name = "ServerPort")
    public Server getServerPort(WebServiceFeature... features) {
        return (Server)super.getPort(new QName("http://service/", "ServerPort"), Server.class);
    }

}
