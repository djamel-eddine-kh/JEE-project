/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author djamel
 */
public class Cart {

 

    private int id;
    private int buyer_id;
    private int product_id;
    private int quantity;
      private double total_price;

    public int getId() {
        return id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public Cart(int buyer_id, int product_id, int quantity) {
        this.buyer_id = buyer_id;
        this.product_id = product_id;
        this.quantity = quantity;
        //this.total_price=quantity*
    }

    

   
    
    
}
