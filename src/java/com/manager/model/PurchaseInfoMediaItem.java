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
public class PurchaseInfoMediaItem implements Serializable{
    
    private int purchaseID;
    private double purchasePrice;
    private String purchaseDate;
    private int locationID;
    private int itemID;
    
    public PurchaseInfoMediaItem() {
        
    }
    
    public int getPurchaseID() {
        return this.purchaseID;
    }
    
    public void setPurchaseID(int id) {
        this.purchaseID = id;
    }
    
    public double getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setPurchasePrice(double price) {
        this.purchasePrice = price;
    }
    
    public String getPurchaseDate() {
        return this.purchaseDate;
    }
    
    public void setPurchaseDate(String date) {
        this.purchaseDate = date;
    }
    
    public int getLocationID() {
        return this.locationID;
    }
    
    public void setLocationID(int id) {
        this.locationID = id;
    }
    
    public int getItemID() {
        return this.itemID;
    }
    
    public void setItemID(int id) {
        this.itemID = id;
    }
}
