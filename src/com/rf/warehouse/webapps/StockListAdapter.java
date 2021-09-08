/**
 * 
 */
package com.rf.warehouse.webapps;

import java.util.List;

import com.rf.warehouse.common.StockItem;
import com.rf.warehouse.generated.webapps.ProductType;
import com.rf.warehouse.generated.webapps.StockListType;

/**
 * Converts the warehouse enterprise classes to the generated class 'StockList'
 */
public class StockListAdapter {
    /**
     * Converts a List<StockItem> to a StockListType. Note that this takes an object returned
     * by the DAO's query method and converts it to the type expected by the WebService.
     * 
     * @param items List to be converted to a StockListType
     * @return StockListType with the same data as the input items
     */
    public StockListType createStockList(List<StockItem> items) {
        StockListType result = new StockListType();
        for (StockItem item : items){
            ProductType p = new ProductType();
            p.setProductId(item.getProductId());
            p.setQuantity(item.getQuantity());
            result.getProduct().add(p);
        }
        return result;        
    }
}
