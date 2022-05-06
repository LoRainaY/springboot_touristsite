package com.zaitsava.springboot_touristsite.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AdminController {
    @RequestMapping("/admin")
    public ModelAndView adminPage(){
        ModelAndView adminPage = new ModelAndView();
        adminPage.setViewName("user/admin/adminPage");
        return adminPage;
    }
}
