/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.controllers;

import com.infosys.shoppingcart.models.Response;
import com.infosys.shoppingcart.models.UserModel;
import com.infosys.shoppingcart.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adriana
 */
@RestController
public class Authenticate {
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @PostMapping(value="/users/login")
    public ResponseEntity<?> login (@RequestBody UserModel user){
        String username = user.getUsername();
        String password = user.getPassword();
        
        if(username==null || password == null)
        return new ResponseEntity<String>("Unauthorized",HttpStatus.OK );
        
        UserModel retval = userService.login(username, password);
        
        if (retval!=null){
            return new ResponseEntity<UserModel>(retval, HttpStatus.OK);
        }
        else{
             return new ResponseEntity<String>("Unauthorized",HttpStatus.OK );
        }
        
    }  
    
    @PostMapping(value="/users/register")
    public ResponseEntity<?> register (@RequestBody UserModel user){
        
       Response retval = new Response();
     
       if (null != userService.register(user)){
	  retval.setCode(1);
          retval.setDesc("Created");
       }else{
	  retval.setCode(0);
          retval.setDesc("Failed");
          return new ResponseEntity< Response>(retval, HttpStatus.BAD_REQUEST);
	}
       
       return new ResponseEntity<Response>(retval,HttpStatus.CREATED);
    }
    
    @GetMapping(value="/users/search")
    public ResponseEntity<?> searchUsers(@RequestParam(name="username",required=false, defaultValue="null") String username ){
       
      if (username==null)
         return new ResponseEntity<String>("No Content",HttpStatus.NO_CONTENT ); 
        
      if (!userService.checkToken())
       return new ResponseEntity<String>("Unauthorized",HttpStatus.OK ); 
           
       if (!username.equalsIgnoreCase("null") && !username.isEmpty())  {
        List<UserModel> retval = userService.search(username);
        return new ResponseEntity<List<UserModel>>(retval,HttpStatus.OK);
       }
        
       List<UserModel> retval = userService.findAll();
       return new ResponseEntity<List<UserModel>>(retval,HttpStatus.OK);
    }
    
    //Se usa @ResponseStatus(HttpStatus.NO_CONTENT), si el controller es tipo void
    
    @GetMapping(value="/users/hello/{name}")
    public ResponseEntity<?> hello(@PathVariable String name ){
        List<Response> list = new ArrayList<>();
        Response retval = new Response();
        retval.setDesc("Hello:"+name);
        retval.setCode(1);
        list.add(retval);
       
               return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
