package com.rf.warehouse.backend;

import java.util.List;

import com.rf.warehouse.common.StockItem;
import com.rf.warehouse.common.StockItemDAO;

import junit.framework.TestCase;


/**
 * @author ROI
 * 
 */
public class StockItemDAOTest extends TestCase {
    protected StockItemDAO dao;
    
    @Override
    protected void setUp() throws Exception {
        dao = new StockItemDAOJDBCImpl();
    }

    @Override
    protected void tearDown() {
        dao.close();
    }

    public void testLowStockQuery(){
        int thresh = 2;
        List<StockItem> items = dao.getStockItemsWithQuantityLessThan(thresh);
        assertTrue(items.size() > 0);
        for (StockItem item : items){
            System.out.println("Found " + item);
            assertTrue(item.getQuantity() < thresh);
        }
    }
    
    public void testRangeQuery(){
        int min = 2;
        int max = 4;
        List<StockItem> items = dao.getStockItemsWithQuantityBetween(min, max);
        assertTrue(items.size() > 0);
        for (StockItem item : items){
            System.out.println("Found " + item);
            assertTrue(item.getQuantity() <= max);
            assertTrue(item.getQuantity() >= min);
        }
    }
    
    public void testItemInStock(){
        boolean inStock = dao.isInStock(3177);
        assertTrue(inStock);
    }
    
    public void testItemNotInStock(){
        boolean inStock = dao.isInStock(3502);
        assertFalse(inStock);
    }
    
    public void testInvalidItem(){
        assertFalse(dao.isInStock(-1));
    }
}
