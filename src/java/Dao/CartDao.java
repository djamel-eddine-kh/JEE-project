/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cart;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Product;
import java.sql.Statement;
import Model.Seller;
/**
 *
 * @author djamel
 */
public class CartDao {
      private  Connection connection; // Database connection object
      private static final String DELETE_USERS_SQL = "delete from Cart where Invoice_id =?;";
    public  CartDao() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        
    }

  public void insertOrUpdateCart(Cart cart) throws SQLException {
    String checkQuery = "SELECT * FROM Cart WHERE Product_id=? AND Buyer_id=?";
    String insertQuery = "INSERT INTO Cart (Buyer_id, Product_id,Quantity_sold) VALUES (?, ?,1)";
    String updateQuery = "UPDATE Cart SET Quantity_sold = Quantity_sold + 1 WHERE Product_id=? AND Buyer_id=?";

    try {
        // Check if the record already exists
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setInt(1, cart.getProduct_id());
        checkStatement.setInt(2, cart.getBuyer_id());
        ResultSet resultSet = checkStatement.executeQuery();

        if (resultSet.next()) {
            // If record exists, update the quantity
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setInt(1, cart.getProduct_id());
            updateStatement.setInt(2, cart.getBuyer_id());
            updateStatement.executeUpdate();
        } else {
            // If record doesn't exist, insert a new record
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, cart.getBuyer_id());
            insertStatement.setInt(2, cart.getProduct_id());
            insertStatement.executeUpdate();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

  
  public List<Product> getAllCarts(int buyerId) throws SQLException {
    List<Product> products = new ArrayList<>();

    try {
PreparedStatement statement = connection.prepareStatement("SELECT b.Buyer_name, p.Product_id, p.Product_name, c.Quantity_sold, Selling_price, p.image FROM Buyer b, Cart c, Product p WHERE p.Product_id = c.product_id AND b.Buyer_id = ?;");
            statement.setInt(1, buyerId);
            ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("Product_id");
            String buyer=resultSet.getString("Buyer_name");
            String product_name=resultSet.getString("Product_name");
            double selling_price=resultSet.getDouble("Selling_price");
            int quantity = resultSet.getInt("Quantity_sold");
            String imagePath=resultSet.getString("image");
            Product product = new Product(id,buyer,product_name,quantity,selling_price,imagePath);
            products.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    

    return products;
}
 /* public Seller getClientByInvoiceId(int invoiceId) throws SQLException {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Seller client = null;

    try {
        // Obtain the database connection
        
        // Prepare the SQL statement
        String query = "SELECT c.* FROM Client c INNER JOIN Invoice i ON c.Client_id = i.Client_id WHERE i.Invoice_number = ?";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, invoiceId);
        
        // Execute the query
        rs = stmt.executeQuery();
        
        // Retrieve the client information
        if (rs.next()) {
            int clientId = rs.getInt("Client_id");
            String clientName = rs.getString("Client_name");
            int telephone = Integer.parseInt( rs.getString("Telephone"));
            String email = rs.getString("Email");
            
            // Create the Client object
            client = new Seller(clientId, clientName, telephone, email);
        }
    } finally {
        // Close the database resources
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
       
    }

    return client;
}*/

  

}
