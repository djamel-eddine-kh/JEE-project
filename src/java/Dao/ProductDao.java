/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author djamel
 */
public class ProductDao {
      private static final String DELETE_Product_SQL = "delete from Product where Product_id =?;";

      private  Connection connection; // Database connection object
    public  ProductDao() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        
    }

 
 
   
  public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (
				PreparedStatement statement = connection.prepareStatement(DELETE_Product_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
  
  public void updateProductQuantity(int ProductId, int quantity) throws SQLException {
  
        // Fetch the current quantity of the Product
        String selectQuery = "SELECT Quantity FROM Product WHERE Product_id = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, ProductId);
           try (ResultSet resultSet = selectStatement.executeQuery()) {
    int currentQuantity = 0;
    if (resultSet.next()) {
        currentQuantity = resultSet.getInt("Quantity");
    }
                // Decrement the quantity by the invoice line quantity
                int newQuantity = currentQuantity - quantity;
                
                // Update the Product's quantity in the database
                String updateQuery = "UPDATE Product SET Quantity = ? WHERE Product_id = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setInt(1, newQuantity);
                    updateStatement.setInt(2, ProductId);
                    updateStatement.executeUpdate();
                }
            }
        }
    }

   public Product getProduct(int id) throws SQLException {
        Product product = null;

        try (
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE Product_id=?");) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("Product_id");
                String name = resultSet.getString("Product_name");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("Selling_price");
                String imagePath = resultSet.getString("image");
              //  int seller_id=resultSet.getInt("Seller_id");

                product = new Product(productId, name, quantity, price, imagePath);
            }
        }

        return product;
    }

    public void insertProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (Product_name, Quantity, Selling_price, image,Seller_id) VALUES (?, ?, ?, ?, ?)";

        try (
             PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantity());
            statement.setDouble(3, product.getSelling_price());
            statement.setString(4, product.getImage());
            statement.setInt(5, product.getSellerId());

            statement.executeUpdate();
        }
    }

public List<Product> getAllProducts() throws SQLException {
    List<Product> products = new ArrayList<>();

    try (
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product");
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int productId = resultSet.getInt("Product_id");
            String name = resultSet.getString("Product_name");
            int quantity = resultSet.getInt("Quantity");
            double price = resultSet.getDouble("Selling_price");
            String imagePath = resultSet.getString("image");
            Product product = new Product(productId, name, quantity, price, imagePath);
            products.add(product);
        }
    }

    return products;
}


}





  




