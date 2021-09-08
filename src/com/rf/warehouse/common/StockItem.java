/**
 * 
 */
package com.rf.warehouse.common;

import java.io.Serializable;

/**
 * An item in the warehouse
 */
public class StockItem implements Serializable {
    private static final long serialVersionUID = 1;
    
    private int productId;
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item number " + productId + " (" + quantity + " available)";
    }

    public StockItem() {
        this(-1, 0);
    }

    public StockItem(int id, int qty) {
        this.productId = id;
        this.quantity = qty;
    }
}
