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
public class Genre implements Serializable {
    
    private int genreID;
    private String genreDescription;
    
    public Genre() {
        
    }
    
    public int getGenreID() {
        return this.genreID;
    }
    
    public void setGenreID(int id) {
        this.genreID = id;
    }
    
    public String getGenreDescription() {
        return this.genreDescription;
    } 
    
    public void setGenreDescription(String desc) {
        this.genreDescription = desc;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Genre)) {
            return false;
        }
        if (o == null) {
            return false;
        }
        Genre g = (Genre) o;
        if (g.getGenreID() == this.getGenreID()) {
            return true;
        } else {
            return false;
        }
    }
    
    public int hashCode() {
        return this.getGenreDescription().hashCode();
    }
}
