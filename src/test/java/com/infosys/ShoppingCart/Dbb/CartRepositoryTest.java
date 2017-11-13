/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.ShoppingCart.Dbb;

import com.infosys.shoppingcart.entities.Cart;
import com.infosys.shoppingcart.repositories.CartRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Adriana
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CartRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    @Qualifier("cartRepository")
    private CartRepository cartRepository;
    
    @Ignore
    @Test
    public void whenFindById_thenReturnCart() {
        // given
        Cart newCart = entityManager.persist(new Cart());
        entityManager.flush();

        // when
        Cart found = cartRepository.findById(newCart.getId());

        // then
        assertThat(found.getId())
          .isEqualTo(newCart.getId());
    }
    
}
