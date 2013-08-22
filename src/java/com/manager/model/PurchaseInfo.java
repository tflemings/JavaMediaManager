/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.model;

import java.io.*;

/**
 *
 * @author Tony
 */
public class PurchaseInfo implements Serializable{
    
    private int locationID;
    private String purchaseLocation;
    
    public PurchaseInfo() {
        
    }
    
    public int getLocationID() {
        return this.locationID;
    }
    
    public void setLocationID(int id) {
        this.locationID = id;
    }
    
    public String getPurchaseLocation() {
        return this.purchaseLocation;
    }
    
    public void setPurchaseLocation(String loc) {
        this.purchaseLocation = loc;
    }
}
