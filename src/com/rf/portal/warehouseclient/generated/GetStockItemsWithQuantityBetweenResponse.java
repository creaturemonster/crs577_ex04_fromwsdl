
package com.rf.portal.warehouseclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stockList" type="{http://warehouse.rf.com/}stockListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "stockList"
})
@XmlRootElement(name = "getStockItemsWithQuantityBetweenResponse")
public class GetStockItemsWithQuantityBetweenResponse {

    @XmlElement(required = true)
    protected StockListType stockList;

    /**
     * Gets the value of the stockList property.
     * 
     * @return
     *     possible object is
     *     {@link StockListType }
     *     
     */
    public StockListType getStockList() {
        return stockList;
    }

    /**
     * Sets the value of the stockList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockListType }
     *     
     */
    public void setStockList(StockListType value) {
        this.stockList = value;
    }

}
