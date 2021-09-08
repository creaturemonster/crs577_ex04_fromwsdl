
package com.rf.portal.warehouseclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="inStock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "inStock"
})
@XmlRootElement(name = "isInStockResponse")
public class IsInStockResponse {

    protected boolean inStock;

    /**
     * Gets the value of the inStock property.
     * 
     */
    public boolean isInStock() {
        return inStock;
    }

    /**
     * Sets the value of the inStock property.
     * 
     */
    public void setInStock(boolean value) {
        this.inStock = value;
    }

}
