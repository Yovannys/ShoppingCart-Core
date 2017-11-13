/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services.impl;

import com.infosys.shoppingcart.Utils.Utils;
import com.infosys.shoppingcart.components.UserConverter;
import com.infosys.shoppingcart.entities.Users;
import com.infosys.shoppingcart.models.CartModel;
import com.infosys.shoppingcart.models.UserModel;
import com.infosys.shoppingcart.repositories.UserRepository;
import com.infosys.shoppingcart.services.CartService;
import com.infosys.shoppingcart.services.UserService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Adriana
 */

 /*Para que Hibernate sepa que que es una entidad nueva o no es por el id:
     * si el id = 0 - Add
     * si el id != 0 - Update
	*/


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
    
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
       
    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;
    
    @Autowired
    @Qualifier("cartServiceImpl")
    private CartService cartService;
        
    @Autowired
    @Qualifier("utils")
    private Utils utils;
    
    private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);
    
    
    @Override
    public UserModel login(String username, String password) {
             
       UserModel userModel = null;
            
           try {
                  Users usr = userRepository.findByUsername(username);
                  
                  if (usr!=null){
                      Users pawsd = userRepository.findByPassword(utils.md5(password));
                       if (pawsd!=null){
                          userModel = userConverter.user2UserModel(pawsd);
                       }
                  }
                                        
           } catch (Exception ex) {
               LOG.error("ERROR METHOD : register -- PARAMS: " + userModel.toString()+ex.getMessage());
               return userModel;
           }
       
       return userModel;
    }
    
    @Override
    public UserModel register(UserModel usermodel){
        UserModel retval = null;
        try {
            usermodel.setToken( utils.generateToken());
            usermodel.setPassword(utils.md5(usermodel.getPassword()));
            Users user = userRepository.save(userConverter.userModel2User(usermodel));
            CartModel cart = cartService.createCart(userConverter.user2UserModel(user));
            if (cart!=null)
            retval = userConverter.user2UserModel(user);
        } catch (UnsupportedEncodingException ex) {
          LOG.error("ERROR METHOD : register -- PARAMS: " + usermodel.toString()+ex.getMessage());
           return retval;
        } catch (NoSuchAlgorithmException ex) {
            LOG.error("ERROR METHOD : register -- PARAMS: " + usermodel.toString()+ex.getMessage());
            return retval;
        }
        return retval;
     }
     
   
    
    @Override
     public List<UserModel> search (String name){
       List<UserModel> retval = new ArrayList<UserModel>();
       List<Users> data = userRepository.findByUsernameContaining(name);
       for (Users items : data) {
           retval.add(userConverter.user2UserModel(items));
       }
        return retval;
     }
     
     @Override
     public List<UserModel> findAll(){
       List<UserModel> retval = new ArrayList<>();
       List<Users> lista = userRepository.findAll();
         for (Users items : lista) {
              retval.add(userConverter.user2UserModel(items));
         }
       return retval;
     }
    
    @Override 
    public boolean checkToken(){
      UserModel usr = getUsernameByToken();
      return (usr!=null);
    }
          
    @Override
    public UserModel getUsernameByToken(){
        
       UserModel retval = null;
        try {
                  
            Map <String, String> datos = utils.getHttpHeaders();
            for (Map.Entry<String, String> entry : datos.entrySet()) {
                String key = entry.getKey();
                if (key.trim().equalsIgnoreCase("api-token")){
                 retval = userConverter.user2UserModel(userRepository.findByToken(entry.getValue()));
                  break;
                }

            }
        } catch (Exception e) {
             return retval;
        }
         return retval;
     }
     
}
