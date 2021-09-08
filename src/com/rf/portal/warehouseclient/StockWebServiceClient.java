/**
 * 
 */
package com.rf.portal.warehouseclient;

import java.util.List;

import javax.xml.ws.BindingProvider;

import com.rf.portal.warehouseclient.generated.ProductType;
import com.rf.portal.warehouseclient.generated.Stock;
import com.rf.portal.warehouseclient.generated.StockListType;
import com.rf.portal.warehouseclient.generated.StockService;

/**
 * Simple client for the Stock SOAP Web service.
 */
public class StockWebServiceClient {
    
    public static void main(String[] args){
        // Create the service and get its port
        Stock stockProxy = new StockService().getStockPort();
        
        System.out.println("Got StockService proxy");
        
        // To redirect requests to soapUI, uncomment the following lines of code 
//        ((javax.xml.ws.BindingProvider) stockProxy).getRequestContext().put(
//            javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
//            "http://localhost:7777");
        
        // Get items whose stock quantity is lower than thresh, 
        // then loop through and print out each item's product id and its quantity
        final int thresh = 2;
        StockListType inventory = stockProxy.getStockItemsWithQuantityLessThan(thresh);
        List<ProductType> items = inventory.getProduct();
        for (ProductType item : items){
            System.out.println("Found " + item.getProductId() + " " + item.getQuantity());
        }
    }
}
