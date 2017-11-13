/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.models;

import java.util.List;
import javax.persistence.Column;

/**
 *
 * @author Adriana
 */
public class CartModel {
    
    private int id;
    private String name;
    private List<ProductModel> listaProducts;

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

    public List<ProductModel> getListaProducts() {
        return listaProducts;
    }

    public void setListaProducts(List<ProductModel> listaProducts) {
        this.listaProducts = listaProducts;
    }
    
    
    
    
}
