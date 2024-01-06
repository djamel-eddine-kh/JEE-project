/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CartDao;
import Dao.ProductDao;
import Model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author djamel
 */
public class ProductList extends HttpServlet {

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
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("user",(String)session.getAttribute("userType"));

 String action = request.getParameter("action");

    if (action != null && action.equals("ajouter")) {
        int productId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the updated client list and forward it to the JSP
        ProductDao productDao = null;
        CartDao cartDao=null;
        Cart cart=null;
        try {
            productDao = new ProductDao();
            productDao.updateProductQuantity(productId,1);
            List<Product> productList = productDao.getAllProducts();
            cartDao=new CartDao();
            cartDao.insertOrUpdateCart(new Cart((int)session.getAttribute("id"),productId,1 ));
            request.setAttribute("products", productList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/ProductList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        // Display the initial client list
        ProductDao productDAO = null;
        try {
            productDAO = new ProductDao();
        } catch (SQLException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Product> productList = null;
        try {
            productList = productDAO.getAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/ProductList.jsp");
        dispatcher.forward(request, response);
}
}




    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
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
