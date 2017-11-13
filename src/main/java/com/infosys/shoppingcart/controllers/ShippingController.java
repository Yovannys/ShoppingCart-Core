/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.controllers;

import com.infosys.shoppingcart.models.CartModel;
import com.infosys.shoppingcart.models.Response;
import com.infosys.shoppingcart.models.ShippingModel;
import com.infosys.shoppingcart.services.ShippingService;
import com.infosys.shoppingcart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adriana
 */

@RestController
public class ShippingController {
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("shippingServiceImpl")
    private ShippingService shippingService;
    
    @PostMapping(value="/shipping/persist")
    public ResponseEntity<?> persists (@RequestBody ShippingModel shippingModel){
       
       Response retval = new Response();
        
       if (!userService.checkToken())
       return new ResponseEntity<String>("Unauthorized",HttpStatus.OK ); 
        
       if (shippingModel!=null){
           ShippingModel data = shippingService.persit(shippingModel);
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
