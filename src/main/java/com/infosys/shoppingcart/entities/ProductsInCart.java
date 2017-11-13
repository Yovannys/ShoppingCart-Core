/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Adriana
 */

@Entity
@Table(name = "productsInCart")
public class ProductsInCart implements java.io.Serializable{
    
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
    
    @Column(name = "date")
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    public ProductsInCart() {
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", descript=" + descript + ", price=" + price + ", cart=" + cart + '}';
    }   
    
}
