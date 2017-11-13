/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.services.impl;

import com.infosys.shoppingcart.components.ProductConverter;
import com.infosys.shoppingcart.entities.Products;
import com.infosys.shoppingcart.models.ProductModel;
import com.infosys.shoppingcart.repositories.ProductRepository;
import com.infosys.shoppingcart.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adriana
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    @Qualifier("productRepository")
    private ProductRepository productRepository;
    
    @Autowired
    @Qualifier("productConverter")
    private ProductConverter productConverter;
    
   // private static final Log LOG = LogFactory.getLog(ProductServiceImpl.class);

    @Override
    public List<ProductModel> findAll() {
       List<ProductModel> retval = new ArrayList<>();
       List<Products> lista = productRepository.findAll();
         for (Products items : lista) {
              retval.add(productConverter.product2ProductModel(items));
         }
       return retval;
    }
    
    @Override
    public List<ProductModel> search (String name){
       List<ProductModel> retval = new ArrayList<ProductModel>();
       List<Products> data = productRepository.findByProductsContaining(name);
       for (Products items : data) {
           retval.add(productConverter.product2ProductModel(items));
       }
        return retval;
     }
    
}
