/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services;

import com.infosys.shoppingcart.entities.Users;
import com.infosys.shoppingcart.models.UserModel;
import java.util.List;

/**
 *
 * @author Adriana
 */
public interface UserService {
    
    public UserModel login (String username, String password);
    
    public UserModel register(UserModel usermodel);
    
    public List<UserModel> search (String name);
    
    public boolean checkToken();
    
    public UserModel getUsernameByToken();
    
    public List<UserModel> findAll();    
 
    
}
