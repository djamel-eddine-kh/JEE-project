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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author djamel
 */
public class SellerDao {
      private  Connection connection; // Database connection object
      private static final String DELETE_Seller_SQL = "delete from Seller where Seller_id =?;";
    public  SellerDao() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        
    }

    public void insertSeller(Seller Seller) throws SQLException {
       String query = "INSERT INTO Seller (Seller_name,Telephone,Email) VALUES (?,?,?)";
     
      try {  
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Seller.getName());
        statement.executeUpdate();
      
      }catch (SQLException e) {
          e.printStackTrace();
        }
    }
  public List<Seller> getAllSellers() {
    List<Seller> Sellers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Seller");
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int id=resultSet.getShort("Seller_id");
            String SellerName = resultSet.getString("Seller_name");
            int SellerPhone = resultSet.getInt("Telephone");
            String SellerEmail = resultSet.getString("Email");

            Seller Seller = new Seller(id,SellerName);
            Sellers.add(Seller);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception appropriately
    }

    return Sellers;
}
  public Seller getSeller(String name,String password) {
   Seller seller=null;
    try (
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Seller where Seller_name=? and Seller_key=?;");){
         statement.setString(1, name);
         statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id=resultSet.getShort("Seller_id");
            String SellerName = resultSet.getString("Seller_name");

            seller = new Seller(id,SellerName);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception appropriately
    }
          return seller;

   
}        
public boolean deleteSeller(int id) throws SQLException {
		boolean rowDeleted;
		try (
				PreparedStatement statement = connection.prepareStatement(DELETE_Seller_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
