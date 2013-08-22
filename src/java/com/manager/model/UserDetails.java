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
public class UserDetails implements Serializable {
    
    private int id;
    private String username;
    private String password;
    private int authlevel;
    
    public UserDetails() {
        
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int i) {
        this.id = i;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String n) {
        this.username = n;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String p) {
        this.password = p;
    }
    
    public int getAuthlevel() {
        return this.authlevel;
    }
    
    public void setAuthlevel(int a) {
        this.authlevel = a;
    }
    
    public String toString() {
        if (this.username == null && this.password == null) {
            return "The user is null";
        } else {
            return "The username is " + this.username + " The authlevel is " + new Integer(this.authlevel).toString();
        }
    }
}
