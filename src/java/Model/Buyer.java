/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author djamel
 */
public class Buyer {
     private int id;
    private String name;
    private String pass;

    
    public  Buyer(int id,String client_name) {
        this.id=id;
        this.name = client_name;
    }

    public Buyer(String name, String pass) {
this.name=name;
this.pass=pass;
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

}
