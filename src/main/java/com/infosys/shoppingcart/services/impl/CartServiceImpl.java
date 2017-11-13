/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services.impl;

import com.infosys.shoppingcart.components.CartConverter;
import com.infosys.shoppingcart.components.ProductConverter;
import com.infosys.shoppingcart.entities.Cart;
import com.infosys.shoppingcart.entities.Products;
import com.infosys.shoppingcart.entities.ProductsInCart;
import com.infosys.shoppingcart.models.CartModel;
import com.infosys.shoppingcart.models.ProductModel;
import com.infosys.shoppingcart.models.UserModel;
import com.infosys.shoppingcart.repositories.CartRepository;
import com.infosys.shoppingcart.repositories.ProductInCartRepository;
import com.infosys.shoppingcart.services.CartService;

import com.infosys.shoppingcart.services.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adriana
 */
@Service("cartServiceImpl")
public class CartServiceImpl implements CartService{
  
    @Autowired
    @Qualifier("cartRepository")
    private CartRepository cartRepository;
    
    @Autowired
    @Qualifier("productInCartRepository")
    private ProductInCartRepository productInCartRepository;
    
    @Autowired
    @Qualifier("cartConverter")
    private CartConverter cartConverter;
    
    @Autowired
    @Qualifier("productConverter")
    private ProductConverter productConverter;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
       
      
    
    @Override
    public CartModel createCart(UserModel userModel){
      CartModel cartModel = new CartModel();
      cartModel.setId(userModel.getId());
      cartModel.setName("Cart-User_"+userModel.getId());
      return cartConverter.cart2cartModel(cartRepository.save(cartConverter.cartModel2Cart(cartModel)));
   }

    @Override
    public CartModel putProductInCar(ProductModel productModel) {
        
       CartModel cartModel = findCartByUser();
       return putProduct(cartModel,productModel);
       
    }
    
    private CartModel putProduct(CartModel cartModel,ProductModel productModel){
        Cart cart = cartConverter.cartModel2Cart(cartModel);
        Products products = productConverter.productModel2Product(productModel);
        ProductsInCart producIncart = productConverter.products2ProductsInCart(products, cart);
        productInCartRepository.save(producIncart);
        return cartConverter.cart2cartModel(cart);
    }
    
    @Override
    public CartModel findCartByUser(){
        UserModel usr = userService.getUsernameByToken();
        Cart cart = cartRepository.findById(usr.getId());
        if (cart==null){
          CartModel cartModel = createCart(usr);
          return cartModel;
        }
        return cartConverter.cart2cartModel(cart);
    } 
    
    public CartModel findById(int id){
        return cartConverter.cart2cartModel(cartRepository.findById(id));
    }
   
}
