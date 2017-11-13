/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.components;

import com.infosys.shoppingcart.entities.Cart;
import com.infosys.shoppingcart.models.CartModel;
import com.infosys.shoppingcart.models.ProductModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adriana
 */

@Component("cartConverter")
public class CartConverter {
    
   public Cart cartModel2Cart(CartModel cartModel){
       Cart retval = new Cart();
       retval.setId(cartModel.getId());
       retval.setName(cartModel.getName());
       if (cartModel.getListaProducts()!=null && !cartModel.getListaProducts().isEmpty()){
           Set set = new HashSet(cartModel.getListaProducts());
           retval.setProductsInCart(set);
       }else{
           List<ProductModel> listaProductModel = new ArrayList<>();
           Set set = new HashSet(listaProductModel);
           retval.setProductsInCart(set);
       }     
      
       return retval;
   }    
   
   public CartModel cart2cartModel(Cart cart){
      CartModel retval = new CartModel();
      retval.setId(cart.getId());
      retval.setName(cart.getName());
      if(cart.getProductsInCart()!=null && !cart.getProductsInCart().isEmpty()){
             List list = new ArrayList(cart.getProductsInCart());
             retval.setListaProducts(list);
      }else{
              List<ProductModel> listaProduct = new ArrayList<>();
             retval.setListaProducts(listaProduct);
      }
   
      return retval;
   }  
   
}
