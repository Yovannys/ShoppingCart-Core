/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adriana
 */

@Entity
@Table(name = "products")
public class Products {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "descript")
    private String descript;
    
    @Column(name = "price")
    private String price;
    
   
    public Products() {
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

    public String getDesc() {
        return descript;
    }

    public void setDesc(String descript) {
        this.descript = descript;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

       
    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", descript=" + descript + ", price=" + price + '}';
    }   
    
}
