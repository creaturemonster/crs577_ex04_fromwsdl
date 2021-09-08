/**
 * 
 */
package com.rf.portal.warehouseclient;

import java.util.List;

import org.junit.*;

import com.rf.portal.warehouseclient.generated.ProductType;
import com.rf.portal.warehouseclient.generated.Stock;
import com.rf.portal.warehouseclient.generated.StockListType;
import com.rf.portal.warehouseclient.generated.StockService;

import static org.junit.Assert.*;

/**
 * StockWebServiceIntegrationTest defines integration tests for the Stock 
 * Web service. Test cases send SOAP messages to the service and verify
 * the response messages. Test cases require certain items to be present
 * in the inventory database.
 */
public class StockWebServiceIntegrationTest {
    
    private Stock stockPort;
    
    @Before
    public void setUp(){
        stockPort = new StockService().getStockPort();
        assertTrue(stockPort != null);
//        System.out.println("Got StockService port successfully");
    }
    
    @Test
    public void testLowStockQuery(){
        int thresh = 2;
        StockListType inventory = stockPort.getStockItemsWithQuantityLessThan(thresh);
        List<ProductType> items = inventory.getProduct();
        assertTrue(items.size() > 0);
        for (ProductType item : items){
//            System.out.println("Found " + item.getProductId() + " " + item.getQuantity());
            assertTrue(item.getQuantity() < thresh);
        }
    }
    
    @Test
    public void testRangeQuery(){
        int min = 2;
        int max = 4;
        StockListType inventory = stockPort.getStockItemsWithQuantityBetween(min, max);
        List<ProductType> items = inventory.getProduct();
        assertTrue(items.size() > 0);
        for (ProductType item : items){
//            System.out.println("Found " + item.getProductId() + " " + item.getQuantity());
            assertTrue(item.getQuantity() >= min);
            assertTrue(item.getQuantity() <= max);
        }
    }
    
    @Test
    public void testItemInStock(){
        boolean inStock = stockPort.isInStock(3177);
        assertTrue(inStock);
    }
    
    @Test
    public void testItemNotInStock(){
        boolean inStock = stockPort.isInStock(3502);
        assertFalse(inStock);
    }
    
    @Test
    public void testInvalidItem(){
        assertFalse(stockPort.isInStock(-1));
    }

}
