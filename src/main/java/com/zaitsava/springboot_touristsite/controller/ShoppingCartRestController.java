package com.zaitsava.springboot_touristsite.controller;

import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.service.ShoppingCartService;
import com.zaitsava.springboot_touristsite.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShoppingCartRestController {
    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/cart/add/{pid}/{qty}")
    public String addTourToCart(@PathVariable("pid")Integer tourId,
                                @PathVariable("qty")Integer quantity,
                                @AuthenticationPrincipal Authentication authentication){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("tourId"+tourId+"- quantity"+quantity+"-"+authentication.toString());
        if(authentication==null||authentication instanceof AnonymousAuthenticationToken){
            System.out.println("authentication is null");
            return "Ваш нужно войти чтобы добавить этот тур в вашу корзину либо заказать тур по телефону";
        }
        User user = userService.findUserByEmail(authentication.getName());
        if(user==null) System.out.println("User is null");
        Integer addedQuantity=cartService.addTour(tourId,quantity,user);
        return addedQuantity+" шт. тура были добавлены в вашу корзину.";
    }
/*
    @PostMapping("/cart/remove/{pid}")
    public String removeItemFromCart(@PathVariable("pid")Integer tourId,
                                @AuthenticationPrincipal Authentication authentication){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null||authentication instanceof AnonymousAuthenticationToken){
            return "Ваш нужно войти чтобы удалить этот тур";
        }
        User user = userService.findUserByEmail(authentication.getName());
        if(user==null) System.out.println("User is null");

        cartService.removeItem(tourId,user);
        return "Тур удален с вашей корзины.";
    }
*/

}
