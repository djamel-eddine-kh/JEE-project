/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Buyer;
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
public class BuyerDao {
      private  Connection connection; // Database connection object
      private static final String DELETE_Buyer_SQL = "delete from Buyer where Buyer_id =?;";
    public  BuyerDao() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        
    }

    public void insertBuyer(Buyer Buyer) throws SQLException {
       String query = "INSERT INTO Buyer (Buyer_name,Telephone,Email) VALUES (?,?,?)";
     
      try {  
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Buyer.getName());
        statement.executeUpdate();
      
      }catch (SQLException e) {
          e.printStackTrace();
        }
    }
  public List<Buyer> getAllBuyers() {
    List<Buyer> Buyers = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Buyer");
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int id=resultSet.getShort("Buyer_id");
            String BuyerName = resultSet.getString("Buyer_name");
            int BuyerPhone = resultSet.getInt("Telephone");
            String BuyerEmail = resultSet.getString("Email");

            Buyer Buyer = new Buyer(id,BuyerName);
            Buyers.add(Buyer);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception appropriately
    }

    return Buyers;
}
  public Buyer getBuyer(String name,String password) {
   Buyer Buyer=null;
    try (
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Buyer where Buyer_name=? and Buyer_key=?;");){
         statement.setString(1, name);
         statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id=resultSet.getShort("Buyer_id");
            String BuyerName = resultSet.getString("Buyer_name");

            Buyer = new Buyer(id,BuyerName);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception appropriately
    }
          return Buyer;

   
}        
public boolean deleteBuyer(int id) throws SQLException {
		boolean rowDeleted;
		try (
				PreparedStatement statement = connection.prepareStatement(DELETE_Buyer_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
