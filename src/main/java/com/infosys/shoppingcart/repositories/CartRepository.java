/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.repositories;

import com.infosys.shoppingcart.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adriana
 */

@Repository("cartRepository")
@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer>{
         
      public Cart findById(int id);
      
}
