package com.zaitsava.springboot_touristsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage() {
        return "home/main";
    }
    @RequestMapping("/main")
    public String main() {
        return "redirect:home/main";
    }
    @RequestMapping("/login")
    public ModelAndView goToLoginPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/login");
        return mv;
    }
}
