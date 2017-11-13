/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.components;

import com.infosys.shoppingcart.entities.Users;
import com.infosys.shoppingcart.models.UserModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adriana
 */

@Component("userConverter")
public class UserConverter {
    
    public Users userModel2User(UserModel userModel){
        
        Users users = new Users();
        users.setId(userModel.getId());
        users.setPassword(userModel.getPassword());
        users.setUsername(userModel.getUsername());
        users.setToken(userModel.getToken());
        users.setName(userModel.getName());
        users.setAddress(userModel.getAddress());
        users.setEmail(userModel.getEmail());
        return users;        
    }
    
    
    public UserModel user2UserModel(Users users){
        
        UserModel userModel = new UserModel();
        userModel.setId(users.getId());
        userModel.setPassword(users.getPassword());
        userModel.setUsername(users.getUsername());
        userModel.setToken(users.getToken());
        userModel.setAddress(users.getAddress());
        userModel.setEmail(users.getEmail());
        userModel.setName(users.getName());
        return userModel;        
    }
    
}
