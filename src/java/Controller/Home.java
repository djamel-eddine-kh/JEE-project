/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BuyerDao;
import Model.Buyer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author djamel
 */
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    
    // Check if the login attempts attribute exists in the session
    if (session.getAttribute("loginAttempts") == null) {
        // If not, initialize it to zero
        session.setAttribute("loginAttempts", 0);
    }
    
    int loginAttempts = (int) session.getAttribute("loginAttempts");
    
    String user = request.getParameter("username");
    String password = request.getParameter("password");
    Authentication authentication=new Authentication(user, password);
    if (authentication.VerifyUser()!=null) {
        // Reset the login attempts on successful login
        session.setAttribute("loginAttempts", 0);
        
        session.setAttribute("loggedIn", true);
        session.setAttribute("user",user );
        session.setAttribute("userType",authentication.VerifyUser());
        session.setAttribute("id", authentication.getId());
        request.setAttribute("user",authentication.VerifyUser());
        RequestDispatcher rds = request.getRequestDispatcher("/WEB-INF/view/Home.jsp");
        rds.forward(request, response);}
       
    else {
        // Increment the login attempts
        loginAttempts++;
        session.setAttribute("loginAttempts", loginAttempts);
        
        if (loginAttempts >= 3) {
            // Disable the login button after three failed attempts
            request.setAttribute("disableLogin", true);
            // delay the next try
              try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        request.setAttribute("error", "Invalid username or password");
        RequestDispatcher rds = request.getRequestDispatcher("login.jsp");
        rds.forward(request, response);
    }
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
