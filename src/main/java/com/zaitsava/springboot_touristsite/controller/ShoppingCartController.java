package com.zaitsava.springboot_touristsite.controller;


import com.zaitsava.springboot_touristsite.entity.CartItem;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.CartItemRepository;
import com.zaitsava.springboot_touristsite.service.ShoppingCartService;
import com.zaitsava.springboot_touristsite.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CartItemRepository cartItemRepository;



    @GetMapping("/cart")
    public String showCart(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        if(user==null) System.out.println("User is null");

        List<CartItem> cartItemList=cartService.cartItemList(user);
        model.addAttribute("cartItems",cartItemList);
        return "user/cart";
    }
    @GetMapping("/profile/findOneСart")
    @ResponseBody
    public CartItem findOneUser(Integer id) {
        return cartItemRepository.findById(id).get();
    }

}
