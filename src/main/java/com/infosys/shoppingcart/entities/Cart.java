/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Adriana
 */

@Entity
@Table(name = "cart")
public class Cart implements java.io.Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "cart")
    private Set<ProductsInCart> productsInCart = new HashSet<ProductsInCart>(0);
  
    public Cart() {
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

    public Set<ProductsInCart> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(Set<ProductsInCart> productsInCart) {
        this.productsInCart = productsInCart;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", name=" + name + '}';
    }  
    
    
}
