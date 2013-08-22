/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.model;

import java.io.Serializable;

/**
 *
 * @author Tony
 */
public class PurchaseInfoItemCrossRef implements Serializable {
    
    private int purchaseID;
    private String itemName;
    
    public PurchaseInfoItemCrossRef() {
        
    }
    
    public int getPurchaseID() {
        return this.purchaseID;
    }
    
    public void setPurchaseID(int id) {
        this.purchaseID = id;
    }
    
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String name) {
        this.itemName = name;
    }
}
