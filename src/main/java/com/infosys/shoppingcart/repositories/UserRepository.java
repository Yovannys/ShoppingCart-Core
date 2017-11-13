/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.shoppingcart.entities.Users;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adriana
 */
@Transactional
@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Integer> {
    
    //public Contact findById(int id);
    public Users findByUsername(String username);
    public Users findByPassword(String password);
    public Users findByToken(String password);   
    public List<Users> findAll();   
    
    @Query("Select u from Users u where u.username like %:name%")
    List<Users> findByUsernameContaining(@Param("name") String name);
    
}
