/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.repositories;

import com.infosys.shoppingcart.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adriana
 */
@Transactional
@Repository("shippingRepository")
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    
   
}
