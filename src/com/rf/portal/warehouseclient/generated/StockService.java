
package com.rf.portal.warehouseclient.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StockService", targetNamespace = "http://warehouse.rf.com/", wsdlLocation = "http://localhost:8080/ex04/stock?wsdl")
public class StockService
    extends Service
{

    private final static URL STOCKSERVICE_WSDL_LOCATION;
    private final static WebServiceException STOCKSERVICE_EXCEPTION;
    private final static QName STOCKSERVICE_QNAME = new QName("http://warehouse.rf.com/", "StockService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ex04/stock?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STOCKSERVICE_WSDL_LOCATION = url;
        STOCKSERVICE_EXCEPTION = e;
    }

    public StockService() {
        super(__getWsdlLocation(), STOCKSERVICE_QNAME);
    }

    public StockService(WebServiceFeature... features) {
        super(__getWsdlLocation(), STOCKSERVICE_QNAME, features);
    }

    public StockService(URL wsdlLocation) {
        super(wsdlLocation, STOCKSERVICE_QNAME);
    }

    public StockService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STOCKSERVICE_QNAME, features);
    }

    public StockService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StockService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Stock
     */
    @WebEndpoint(name = "StockPort")
    public Stock getStockPort() {
        return super.getPort(new QName("http://warehouse.rf.com/", "StockPort"), Stock.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Stock
     */
    @WebEndpoint(name = "StockPort")
    public Stock getStockPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://warehouse.rf.com/", "StockPort"), Stock.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STOCKSERVICE_EXCEPTION!= null) {
            throw STOCKSERVICE_EXCEPTION;
        }
        return STOCKSERVICE_WSDL_LOCATION;
    }

}
