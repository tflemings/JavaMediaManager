/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.controller;

import com.manager.model.V_Items;
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
public class SearchForItems extends HttpServlet {

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
        ArrayList<V_Items> searchItems = new ArrayList<V_Items>();
        try {
            DatabaseController dbh = (DatabaseController) getServletContext().getAttribute("database");
            String name = request.getParameter("itemName"); 
            if (request.getSession().getAttribute("all_items") == null) {
                searchItems = dbh.getSearchItems(name);
            } else {
                for (V_Items v : (ArrayList<V_Items>) request.getSession().getAttribute("all_items")) {
                    if (v.getName().toLowerCase().equals(name.toLowerCase())) {
                        searchItems.add(v);
                    }
                }
            }
            request.setAttribute("anItem", searchItems);
            RequestDispatcher view = request.getRequestDispatcher("itemDetails.jsp");
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
