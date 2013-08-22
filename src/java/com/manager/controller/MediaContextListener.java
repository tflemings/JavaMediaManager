/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.controller;

import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Tony
 */
public class MediaContextListener implements ServletContextListener{
    
    public void contextInitialized(ServletContextEvent event) {
        DatabaseController dbh = null;
        String url = event.getServletContext().getInitParameter("databaseURL");
        String queryString = event.getServletContext().getInitParameter("queryString");
        String driver = event.getServletContext().getInitParameter("driver");
        try {
            dbh = new DatabaseController(url + queryString, driver);
        } catch (SQLException e) {
            
        }
        event.getServletContext().setAttribute("database", dbh);
    }
    
    public void contextDestroyed(ServletContextEvent event) {
        
    }
}
