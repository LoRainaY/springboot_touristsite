package com.zaitsava.springboot_touristsite.controller;

import com.zaitsava.springboot_touristsite.dto.ChangeOrderStatusDTO;
import com.zaitsava.springboot_touristsite.dto.OrderDTO;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.OrderRepository;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import com.zaitsava.springboot_touristsite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public void createOrder(@RequestBody OrderDTO orderDTO, Authentication authentication){
        orderService.createOrder(orderDTO,authentication.getName());
    }

    @PostMapping(value = "/changeStatus")
    public void changeStatus(@RequestBody ChangeOrderStatusDTO changeOrderStatusDTO,Authentication authentication){
        User user=userRepository.findByEmail(authentication.getName());
        orderService.changeStatus(changeOrderStatusDTO.getStatus(),changeOrderStatusDTO.getId(),user);
    }

    @PostMapping(value = "/remove/{id}")
    @Transactional
    public void removeOrder(@PathVariable Long id){
       orderRepository.deleteOrderById(id);
    }
}
