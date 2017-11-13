/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.config;

import com.infosys.shoppingcart.entities.Products;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.ProfileResourceProcessor;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 *
 * @author Adriana
 */
@Configuration
public class DataRestConfiguration extends RepositoryRestMvcConfiguration{
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**");
    }

    @Override
    public ProfileResourceProcessor profileResourceProcessor(RepositoryRestConfiguration rrc) {
        rrc.exposeIdsFor(Products.class);
        //rrc.setBasePath("/api");
        //rrc.setBaseUri(new URI("/api"));
        return super.profileResourceProcessor(rrc); 
    }
    
}
