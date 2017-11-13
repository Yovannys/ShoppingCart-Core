/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.components;

import com.infosys.shoppingcart.entities.Shipping;
import com.infosys.shoppingcart.models.ShippingModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adriana
 */

@Component("shippingConverter")
public class ShippingConverter {
    
    public Shipping shippingModel2Shipping(ShippingModel shippingModel){
        Shipping retval = new Shipping();
        retval.setAddress(shippingModel.getAddress());
        retval.setAmount(shippingModel.getAmount());
        retval.setState(shippingModel.getState());
        return retval;
    }
    
    public ShippingModel shipping2shippingModel(Shipping shipping){
        ShippingModel retval = new ShippingModel();
        retval.setAddress(shipping.getAddress());
        retval.setAmount(shipping.getAmount());
        retval.setState(shipping.getState());
        return retval;
    }
    
}
