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
public class MediaType implements Serializable {
    
    private int mediaID;
    private String mediaTypeDescription;
    
    public MediaType() {
        
    }
    
    public int getMediaID() {
        return this.mediaID;
    }
    
    public void setMediaID(int id) {
        this.mediaID = id;
    }
    
    public String getMediaTypeDescription() {
        return this.mediaTypeDescription;
    }
    
    public void setMediaTypeDescription(String desc) {
        this.mediaTypeDescription = desc;
    }
}
