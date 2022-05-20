package com.zaitsava.springboot_touristsite.service;

import com.zaitsava.springboot_touristsite.entity.CartItem;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.CartItemRepository;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private TourRepository tourRepository;

    public List<CartItem> cartItemList(User user){
        return cartItemRepository.findByUser(user);
    };

    public Integer addTour(Integer tourId,Integer quantity, User user){

        Integer addedQuantity=quantity;
        Tour tour=tourRepository.findById(tourId).get();

        if(user==null) System.out.println("Пользователь не найден");

        if(tour==null) System.out.println("Тур не найден");

        CartItem cartItem=cartItemRepository.findByUserAndTour(user,tour);

        if(cartItem!=null){
            addedQuantity=cartItem.getQuantity()+quantity;
            cartItem.setQuantity(addedQuantity);
        }else {
            cartItem=new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setUser(user);
            cartItem.setTour(tour);
        }
        cartItemRepository.save(cartItem);

        return addedQuantity;
    }
}
