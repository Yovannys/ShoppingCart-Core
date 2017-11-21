/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.ShoppingCart.Unit;

import com.infosys.shoppingcart.Utils.Utils;
import com.infosys.shoppingcart.components.UserConverter;
import com.infosys.shoppingcart.entities.Users;
import com.infosys.shoppingcart.repositories.UserRepository;
import com.infosys.shoppingcart.services.CartService;
import com.infosys.shoppingcart.services.UserService;
import com.infosys.shoppingcart.services.impl.UserServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Adriana
 */


// PROBANDO LA CAPA DE SERVICIOS  ( ESQUELETO )

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    
    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public UserServiceImpl userService() {
            return new UserServiceImpl();
        }
    }
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("userRepository")
    @MockBean
    private UserRepository userRepository;
   
    @Ignore
    @Before
    public void setUp() {
        Users usr = new Users();
       
        //Simulando devolver un objeto desde la base de datos
        Mockito.when(userRepository.findByUsername(usr.getUsername()))
          .thenReturn(usr);
    }
    
    @Ignore
    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String name = "yovanotti";
        Users found = (Users) userRepository.findByUsernameContaining(name);

         assertThat(found.getName())
          .isEqualTo(name);
    }
}
