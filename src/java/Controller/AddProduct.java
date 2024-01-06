/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.ProductDao;
import Model.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.http.Part;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.encoder.Encode;

/**
 *
 * @author djamel
 */
public class AddProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/addProductForm.jsp");
        dispatcher.forward(request, response);
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
            HttpSession session = request.getSession();

        String name = request.getParameter("Product_name");
        String quantity = request.getParameter("Quantity");
        String selling_price = request.getParameter("Selling_price");
        Part imagePart = request.getPart("image");

        // Extract file name from Part
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

        // Save the file and get the saved file path
        String savePath = getServletContext().getRealPath("/images");
        String savedFilePath = saveFile(imagePart, savePath, fileName);

        // Sanitize the inputs using OWASP Java Encoder
        String sanitizedName = sanitizeInput(name);
        String sanitizedQuantity = sanitizeInput(quantity);
        String sanitizedSellingPrice = sanitizeInput(selling_price);

        // Create a new Product object with sanitized inputs and saved file path
        Product product = new Product(sanitizedName, Integer.parseInt(sanitizedQuantity),
                Double.valueOf(sanitizedSellingPrice), fileName, (int) session.getAttribute("id"));

        // Use try-with-resources to ensure proper resource management
        ProductDao productDao = new ProductDao();
        
        // Call the ProductDao to insert the product into the database
        productDao.insertProduct(product);

        // Redirect to a success page or display a success message
        response.sendRedirect("ProductList");
    } catch (SQLException | FileNotFoundException ex) {
        Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private String sanitizeInput(String input) {
    if (input != null) {
        // Sanitize the input using OWASP Java Encoder
        return Encode.forHtml(input);
    } else {
        // Handle the case where the input is missing or invalid
        return "";
    }
}



private String saveFile(Part part, String savePath, String fileName) throws IOException {
    String savedFilePath = savePath + File.separator + fileName;

    try (InputStream inputStream = part.getInputStream();
         OutputStream outputStream = new FileOutputStream(savedFilePath)) {

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

    } 

    return savedFilePath;
}

}
