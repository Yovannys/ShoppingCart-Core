/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.controllers;

import com.infosys.shoppingcart.models.CartModel;
import com.infosys.shoppingcart.models.ProductModel;
import com.infosys.shoppingcart.models.Response;
import com.infosys.shoppingcart.services.CartService;
import com.infosys.shoppingcart.services.ProductService;
import com.infosys.shoppingcart.services.UserService;
import com.infosys.shoppingcart.services.impl.CartServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adriana
 */
@RestController
public class ProductController {
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;
    
    @Autowired
    @Qualifier("cartServiceImpl")
    private CartService cartService;
    
    @GetMapping(value="/products/search")
    public ResponseEntity<?> searchProducts(@RequestParam(name="name",required=false, defaultValue="null") String name ){
       
      if (!userService.checkToken())
       return new ResponseEntity<String>("Unauthorized",HttpStatus.OK ); 
           
       if (!name.equalsIgnoreCase("null") && !name.isEmpty())  {
        List<ProductModel> retval = productService.search(name);
        return new ResponseEntity<List<ProductModel>>(retval,HttpStatus.OK);
       }
        
       List<ProductModel> retval = productService.findAll();
       return new ResponseEntity<List<ProductModel>>(retval,HttpStatus.OK);
    }
    
    @PostMapping(value="/products/putInCar")
    public ResponseEntity<?> putInCar (@RequestBody ProductModel productModel){
       
       Response retval = new Response();
        
       if (!userService.checkToken())
       return new ResponseEntity<String>("Unauthorized",HttpStatus.OK ); 
        
       if (productModel!=null){
           CartModel data = cartService.putProductInCar(productModel);
           if (data!=null){
            retval.setCode(1);
            retval.setDesc("Created");
           }else{
            retval.setCode(0);
            retval.setDesc("Failed");
           }
               
       }else{
             return new ResponseEntity< Response>(retval, HttpStatus.BAD_REQUEST);
       }
      
       return new ResponseEntity<Response>(retval,HttpStatus.CREATED);
    }
    
}
