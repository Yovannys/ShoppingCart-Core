/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services;

import com.infosys.shoppingcart.models.CartModel;
import com.infosys.shoppingcart.models.ProductModel;
import com.infosys.shoppingcart.models.UserModel;

/**
 *
 * @author Adriana
 */
public interface CartService {
    
   public CartModel createCart(UserModel userModel);
   public CartModel putProductInCar(ProductModel productModel);
   public CartModel findCartByUser();
    
}
