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
import java.io.IOException;
import java.sql.ResultSet;
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
public class AddRecord extends HttpServlet {

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
        String[] args;
        if (table.equals("genre")) {
            args = new String[2];
            args[0] = table;
            args[1] = request.getParameter("genre_name");
        } else if (table.equals("mediatype")) {
            args = new String[2];
            args[0] = table;
            args[1] = request.getParameter("media_type_name");
        } else if (table.equals("purchaseinfo")) {
            args = new String[2];
            args[0] = table;
            args[1] = request.getParameter("purchase_location");
        } else if (table.equals("purchaseinfomediaitem")) {
            args = new String[5];
            args[0] = table;
            args[1] = request.getParameter("item");
            args[2] = request.getParameter("location");
            args[3] = request.getParameter("price");
            args[4] = request.getParameter("date"); 
        } else {
            args = new String[7];
            args[0] = table;
            args[1] = request.getParameter("item_name");
            args[2] = request.getParameter("genre");
            args[3] = request.getParameter("type");
            args[4] = request.getParameter("year");
            args[5] = request.getParameter("value");
            args[6] = request.getParameter("comments");
        }
        if (args[1] != null || !args[1].equals("")) {
            try {
                DatabaseController dbh = (DatabaseController) getServletContext().getAttribute("database");
                dbh.addRecord(args);
                if (table.equals("genre")) {
                    ArrayList<Genre> genreList = dbh.getDBGenres();
                    request.getSession().setAttribute("genres", genreList);
                } else if (table.equals("mediatype")) {
                    ArrayList<MediaType> mt = dbh.getDBMediaTypes();
                    request.getSession().setAttribute("media_types", mt);
                } else if (table.equals("purchaseinfo")) {
                    ArrayList<PurchaseInfo> pi = dbh.getDBPurchaseInfo();
                    request.getSession().setAttribute("locations", pi);
                } else if (table.equals("purchaseinfomediaitem")) {
                    ArrayList<PurchaseInfoItemCrossRef> xref = dbh.getDBPIXref();
                    request.getSession().setAttribute("xref", xref);
                    ArrayList<MediaItem> noxref = dbh.getNonCross();
                    request.getSession().setAttribute("noxref", noxref);
                } else {
                    ArrayList<MediaItem> mi = dbh.getDBMediaItem();
                    request.getSession().setAttribute("items", mi);
                    ArrayList<MediaItem> noxref = dbh.getNonCross();
                    request.getSession().setAttribute("noxref", noxref);
                }
            } finally {            
            
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("adminhome.jsp");
        view.forward(request, response);
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
