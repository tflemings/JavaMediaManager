/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.controller;

import com.manager.model.Genre;
import com.manager.model.MediaItem;
import com.manager.model.MediaType;
import com.manager.model.PurchaseInfo;
import com.manager.model.PurchaseInfoItemCrossRef;
import com.manager.model.UserDetails;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tony
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            DatabaseController dbh = (DatabaseController) getServletContext().getAttribute("database");
            UserDetails user = dbh.getUserDetails(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            ArrayList<Genre> genreList = dbh.getDBGenres();
            request.getSession().setAttribute("genres", genreList);
            ArrayList<MediaType> mt = dbh.getDBMediaTypes();
            request.getSession().setAttribute("media_types", mt);
            ArrayList<PurchaseInfo> pi = dbh.getDBPurchaseInfo();
            request.getSession().setAttribute("locations", pi);
            ArrayList<MediaItem> mi = dbh.getDBMediaItem();
            request.getSession().setAttribute("items", mi);
            ArrayList<PurchaseInfoItemCrossRef> xref = dbh.getDBPIXref();
            request.getSession().setAttribute("xref", xref);
            ArrayList<MediaItem> noxref = dbh.getNonCross();
            request.getSession().setAttribute("noxref", noxref);
            RequestDispatcher view = request.getRequestDispatcher("adminhome.jsp");
            view.forward(request, response);
        } finally {            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
