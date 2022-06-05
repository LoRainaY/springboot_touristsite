package com.zaitsava.springboot_touristsite.service;


import com.zaitsava.springboot_touristsite.OrderStatusEnum;
import com.zaitsava.springboot_touristsite.dto.OrderDTO;
import com.zaitsava.springboot_touristsite.entity.Order;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.OrderRepository;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TourRepository tourRepository;

    @Transactional
    public void createOrder(OrderDTO orderDTO,String username){
        User user=userRepository.findByEmail(username);
        Tour tour=tourRepository.findById(orderDTO.getTourId()).get();
        Order order=new Order(user,tour,orderDTO.getCount());
        if(user.isGetBonus()){
            order.setDiscountPrice(orderDTO.getDiscountPrice() - (orderDTO.getDiscountPrice()*1/100));
        }
        else {
            order.setDiscountPrice(orderDTO.getDiscountPrice());
        }
        order.setStatus(OrderStatusEnum.unpaid);
        orderRepository.save(order);
    }

    @Transactional
    public void changeStatus(String status,Long id,User user) {
        if(status.equals("finished")){
            user.setGetBonus(true);
        }
        Optional <Order> order=orderRepository.findById(id);
        order.get().setStatus(OrderStatusEnum.valueOf(status));
        orderRepository.save(order.get());
    }
}
