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
public class MediaItem implements Serializable{
    
    private int itemID;
    private int mediaID;
    private int genreID;
    private String name;
    private int year;
    private String comments;
    private double currentValue;
    
    public MediaItem() {
        
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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String c) {
        this.comments = c;
    }
    
    public double getCurrentValue() {
        return this.currentValue;
    }
    
    public void setCurrentValue(double cv) {
        this.currentValue = cv;
    }
}
