package com.rf.warehouse.common;

import java.util.List;

/**
 * Provides queries about the inventory on warehouse datastore.
 */
public interface StockItemDAO {

    public void close();

    // TODO: Note the following three methods, in particular their input and output types
    //       (no changes required)
    public List<StockItem> getStockItemsWithQuantityLessThan(int thresh);

    /** The range is [min,max] i.e. both numbers are included */
    public List<StockItem> getStockItemsWithQuantityBetween(int min, int max);

    public boolean isInStock(int productId);
}
