/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services;

import com.infosys.shoppingcart.models.ProductModel;
import java.util.List;

/**
 *
 * @author Adriana
 */

public interface ProductService {
    
    public List<ProductModel> findAll(); 
    
    public List<ProductModel> search (String name);
}
