/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.components;

import com.infosys.shoppingcart.entities.Cart;
import com.infosys.shoppingcart.entities.Products;
import com.infosys.shoppingcart.entities.ProductsInCart;
import com.infosys.shoppingcart.models.ProductModel;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adriana
 */
@Component("productConverter")
public class ProductConverter {
    
  public Products productModel2Product(ProductModel productModel){
        Products retval = new Products();
        retval.setDesc(productModel.getDescript());
        retval.setId(productModel.getId());
        retval.setName(productModel.getName());
        retval.setPrice(productModel.getPrice());
        return retval;
  }
  
  public ProductModel product2ProductModel(Products product){
        ProductModel retval = new ProductModel();
        retval.setDescript(product.getDesc());
        retval.setId(product.getId());
        retval.setName(product.getName());
        retval.setPrice(product.getPrice());
        return retval;
  }
    
  public ProductsInCart products2ProductsInCart(Products product, Cart cart){
      ProductsInCart retval = new ProductsInCart();
      retval.setCart(cart);
      retval.setDesc(product.getDesc());
      retval.setName(product.getName());
      retval.setPrice(product.getPrice());
      retval.setDate(new Date());
      return retval;
  }
  
    
}
