package com.zaitsava.springboot_touristsite.controller;


import com.zaitsava.springboot_touristsite.entity.Order;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.OrderRepository;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

@PreAuthorize("hasRole('ADMIN')")

public class AdminController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TourRepository tourRepository;

    @RequestMapping("/admin")
    public ModelAndView adminPage(){
        ModelAndView adminPage = new ModelAndView();
        adminPage.setViewName("admin/adminPage");
        return adminPage;
    }
    @GetMapping("/admin/tourList")
    public String adminPageShowTours(Model model) {
        model.addAttribute("tours",tourRepository.findAll());
        return "admin/tourList";
    }


    @RequestMapping("/admin/createTour")
    public ModelAndView goToPageOfCreatingTour(){
        ModelAndView adminPage = new ModelAndView();
        Tour tour=new Tour();
        adminPage.setViewName("admin/addTour");
        adminPage.addObject("tour",tour);
        return adminPage;
    }

    @RequestMapping("/admin/orders")
    public ModelAndView getAllOrders(){
        ModelAndView adminPage = new ModelAndView();
        List<Order> orderList=orderRepository.findAll();
        adminPage.setViewName("admin/orders");
        adminPage.addObject("orders",orderList);
        return adminPage;
    }

    @GetMapping("/admin/userList")
    public ModelAndView userList() {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/userList");
        model.addObject("users",userRepository.findAll());
        return model;
    }


}
