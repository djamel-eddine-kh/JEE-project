/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Blob;

/**
 *
 * @author djamel
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private String image;
    private double selling_price;
    private double total_price;
    private int sellerId;
    private String buyer;

    public Product(String name, int quantity, double selling_price) {
        this.name = name;
        this.quantity = quantity;
        this.selling_price = selling_price;
    }

    public Product(int id, String name, int quantity, double selling_price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.selling_price = selling_price;
        total_price=selling_price*quantity;
    }

    public Product(String name, int quantity, double selling_price,String image,int sellerId) {
        this.name = name;
        this.quantity = quantity;
        this.selling_price = selling_price;
        this.image=image;
        this.sellerId=sellerId;
    }

    public Product(int productId, String name, int quantity, double price, String imagePath) {
 this.id = productId;
        this.name = name;
        this.quantity = quantity;
        this.selling_price = price;
        this.image = imagePath;    }

    public Product(int id, String buyer, String article_name, int quantity, double selling_price, String imagePath) {
        this.id=id;
        this.buyer = buyer;
        this.name = name;
        this.quantity = quantity;
        this.selling_price = selling_price;
        this.image = imagePath;    
        this.total_price=quantity*selling_price;
    }

    public int getSellerId() {
        return sellerId;
    }

    
    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public String getImage() {
        return image;
    }
    
    
}
