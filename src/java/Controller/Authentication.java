/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BuyerDao;
import Dao.SellerDao;
import Model.Buyer;
import Model.Seller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djamel
 */
public class Authentication {
    private String name ;
    private String password;
    private int id;
    
    public Authentication(String name,String passwrod){
        this.name=name;
        this.password=passwrod;
        
    }
    public String VerifyUser(){
                BuyerDao buyerDao = null;
                 Buyer buyer=null;
    try {
            buyerDao=new BuyerDao();
            buyer=buyerDao.getBuyer(name, password);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex+"authentificatio problem");
        }
    if(buyer==null){
        
                SellerDao sellerDao = null;
                 Seller seller=null;
    try {
            sellerDao=new SellerDao();
               seller=sellerDao.getSeller(name, password);

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex+"authentificatio problem");
        }
    if (seller!=null){
        this.id=seller.getId();
        return "seller";}
    else return null;
    } 
    else {
        this.id=buyer.getId();
        return "buyer";}
    }

    public int getId() {
        return id;
    }
}
