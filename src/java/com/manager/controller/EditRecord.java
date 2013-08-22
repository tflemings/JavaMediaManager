/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.controller;

import com.manager.model.Genre;
import com.manager.model.MediaType;
import com.manager.model.PurchaseInfo;
import com.manager.model.PurchaseInfoMediaItem;
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
public class EditRecord extends HttpServlet {

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
        String table = request.getParameter("submit");
        String[] args = null;
        if (table.equals("genre")) {
            args = new String[3];
            args[0] = table;
            args[1] = request.getParameter("e_genre_id");
            args[2] = request.getParameter("e_genre_name");
        } else if (table.equals("mediatype")) {
            args = new String[3];
            args[0] = table;
            args[1] = request.getParameter("e_media_id");
            args[2] = request.getParameter("e_media_type_name");
        } else if (table.equals("purchaseinfo")) {
            args = new String[3];
            args[0] = table;
            args[1] = request.getParameter("e_purchase_id");
            args[2] = request.getParameter("e_purchase_location");
        } else {
        
        }
        try {
            DatabaseController dbh = (DatabaseController) getServletContext().getAttribute("database");
            dbh.editRecord(args);
            if (table.equals("genre")) {
                ArrayList<Genre> genreList = dbh.getDBGenres();
                request.getSession().setAttribute("genres", genreList);
            } else if(table.equals("mediatype")) {
                ArrayList<MediaType> mt = dbh.getDBMediaTypes();
                request.getSession().setAttribute("media_types", mt);
            } else if (table.equals("purchaseinfo")) {
                ArrayList<PurchaseInfo> pi = dbh.getDBPurchaseInfo();
                request.getSession().setAttribute("locations", pi);
            } else if (table.equals("purchaseinfomediaitem")) {
                PurchaseInfoMediaItem item = dbh.getPurchaseInfo(request.getParameter("item_id"));
                request.setAttribute("purchase_ifo", item);
                RequestDispatcher view = request.getRequestDispatcher("/Protected/editInfo.jsp");
                view.forward(request, response);
            }
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
