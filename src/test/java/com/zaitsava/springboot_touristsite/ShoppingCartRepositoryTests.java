package com.zaitsava.springboot_touristsite;

import com.zaitsava.springboot_touristsite.entity.CartItem;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.CartItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ShoppingCartRepositoryTests {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddOneCartItem(){ // добавление тура в корзину
       Tour tour=entityManager.find(Tour.class,10);
       User user=entityManager.find(User.class,4);

        CartItem newCartItem=new CartItem();
        newCartItem.setTour(tour);
        newCartItem.setUser(user);
        newCartItem.setQuantity(1);

        CartItem savedCartItem=cartItemRepository.save(newCartItem);
        assertTrue(savedCartItem.getId()>0);
    }

    @Test
    public void testGetItemByUser(){ // получение тура в корзине по id пользователя
        User user=new User();
        user.setId(4);

        List<CartItem> cartItem=cartItemRepository.findByUser(user);
        assertEquals(1,cartItem.size());
    }
    @Test
    public void testDeleteOneCartItem(){ // удаление тура из корзины
        Tour tour=entityManager.find(Tour.class,5);
        User user=entityManager.find(User.class,4);
        CartItem currentCartItem=cartItemRepository.findByUserAndTour(user,tour);
        cartItemRepository.delete(currentCartItem);
        List<CartItem> cartItem=cartItemRepository.findByUser(user);

        assertEquals(1,cartItem.size());
    }
}
