package com.zaitsava.springboot_touristsite.controller;


import com.zaitsava.springboot_touristsite.entity.Tour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AdminController {
    @RequestMapping("/admin")
    public ModelAndView adminPage(){
        ModelAndView adminPage = new ModelAndView();
        adminPage.setViewName("admin/adminPage");
        return adminPage;
    }



    @RequestMapping("admin/createTour")
    public ModelAndView createTour(){
        ModelAndView adminPage = new ModelAndView();
        Tour tour=new Tour();
        adminPage.setViewName("admin/addTour");
        adminPage.addObject("tour",tour);
        return adminPage;
    }

}
