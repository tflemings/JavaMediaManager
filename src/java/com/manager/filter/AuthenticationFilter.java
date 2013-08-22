/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.filter;

import com.manager.model.UserDetails;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tony
 */
public class AuthenticationFilter implements Filter {
    
    public AuthenticationFilter() {
        
    }
    
    public void init(FilterConfig config) throws ServletException {
        
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
	HttpServletResponse res = (HttpServletResponse)response;
        UserDetails user = (UserDetails) req.getSession().getAttribute("user");
        if (user.getAuthlevel() != 1) {
            RequestDispatcher view = request.getRequestDispatcher("adminhome.jsp");
            view.forward(req, res);
        }
	chain.doFilter(req, res);
    }
    
    public void destroy() {
        
    }
    
}
