/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.ShoppingCart.Config;

import com.infosys.shoppingcart.services.UserService;
import com.infosys.shoppingcart.services.impl.UserServiceImpl;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Adriana
 * 
 *                      //DIFERENCIAS ENTRE @SpringBootTest Y @WebMvcTest
 * 
 * @SpringBootTest - annotation tells Spring Boot to go and look for a main configuration 
 *                   class (one with @SpringBootApplication for instance), 
 *                   and use that to start a Spring application context. SpringBootTest 
 *                   loads complete application and injects all the beans which is can be slow.

     @WebMvcTest  - for testing the controller layer and you need to provide remaining dependencies 
     *              required using Mock Objects. This is much faster as we only load a tiny portion of your app.
 * 
 * 
 */

@RunWith(SpringRunner.class)
public class UserServiceTest {
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Ignore
    @Test
    public void test_userService_always_return_false() {

        //assert correct type/impl
        assertThat(userService, instanceOf(UserServiceImpl.class));

        //assert true
        assertThat(userService.checkToken(), is(false));

    }
    
}
