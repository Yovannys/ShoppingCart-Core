/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.repositories;

import com.infosys.shoppingcart.entities.Products;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adriana
 */
@Repository("productRepository")
@Transactional
public interface ProductRepository extends JpaRepository<Products, Integer>{
    
    public List<Products> findAll();   
    
    @Query("Select p from Products p where p.name like %:name%")
    List<Products> findByProductsContaining(@Param("name") String name);   
   
    
}
