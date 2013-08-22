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
public class V_Items implements Serializable{
    
    private int itemID;
    private int mediaID;
    private int genreID;
    private int purchaseID;
    private int locationID;
    private String name;
    private String mediaTypeDescription;
    private String genreDescription;
    private int year;
    private double currentValue;
    private String comments;
    private double purchasePrice;
    private String purchaseLocation;
    private String purchaseDate;
    
    public V_Items() {
        
    }
    
    public int getItemID() {
        return this.itemID;
    }
    
    public void setItemID(int id) {
        this.itemID = id;
    }
    
    public int getMediaID() {
        return this.mediaID;
    }
    
    public void setMediaID(int id) {
        this.mediaID = id;
    }
    
    public int getGenreID() {
        return this.genreID;
    }
    
    public void setGenreID(int id) {
        this.genreID = id;
    }
    
    public int getPurchaseID() {
        return this.purchaseID;
    }
    
    public void setPurchaseID(int id) {
        this.purchaseID = id;
    }
    
    public int getLocationID() {
        return this.locationID;
    }
    
    public void setLocationID(int id) {
        this.locationID = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMediaTypeDescription() {
        return this.mediaTypeDescription;
    }
    
    public void setMediaTypeDescription(String desc) {
        this.mediaTypeDescription = desc;
    }
    
    public String getGenreDescription() {
        return this.genreDescription;
    }
    
    public void setGenreDescription(String desc) {
        this.genreDescription = desc;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int y) {
        this.year = y;
    }
    
    public double getCurrentValue() {
        return this.currentValue;
    }
    
    public void setCurrentValue(double v) {
        this.currentValue = v;
    }
    
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String c) {
        this.comments = c;
    }
    
    public double getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setPurchasePrice(double p) {
        this.purchasePrice = p;
    }
    
    public String getPurchaseLocation() {
        return this.purchaseLocation;
    }
    
    public void setPurchaseLocation(String pl) {
        this.purchaseLocation = pl;
    }
    
    public String getPurchaseDate() {
        return this.purchaseDate;
    }
    
    public void setPurchaseDate(String d) {
        this.purchaseDate = d;
    }
}
