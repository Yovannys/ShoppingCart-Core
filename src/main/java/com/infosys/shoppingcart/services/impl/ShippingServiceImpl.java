/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services.impl;

import com.infosys.shoppingcart.components.ShippingConverter;
import com.infosys.shoppingcart.models.ShippingModel;
import com.infosys.shoppingcart.models.UserModel;
import com.infosys.shoppingcart.repositories.ShippingRepository;
import com.infosys.shoppingcart.services.MailSender;
import com.infosys.shoppingcart.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adriana
 */
@Service("shippingServiceImpl")
public class ShippingServiceImpl implements ShippingService{
    
    @Autowired
    @Qualifier("shippingRepository")
    private ShippingRepository shippingRepository;
    
    @Autowired
    @Qualifier("shippingConverter")
    private ShippingConverter shippingConverter;
    
    @Autowired
    @Qualifier("mailSenderImpl")
    public MailSender mailSender;
    
    @Autowired
    @Qualifier("userServiceImpl")
    public UserServiceImpl userServiceImpl;
    
    
    
    public ShippingModel persit(ShippingModel shippingModel){
        sendEmail();
        return shippingConverter.shipping2shippingModel(shippingRepository.save(shippingConverter.shippingModel2Shipping(shippingModel)));
    }
    
    public void sendEmail(){
              
        String from = "no-replay@gmail.com";
        String subject = "About Shipping";
        String body = "Your Shipping is in processs. You will receive the products in 5 days";
        UserModel user = userServiceImpl.getUsernameByToken();
         mailSender.send(from, user.getEmail(), subject,body, true);
    
    }
    
}
