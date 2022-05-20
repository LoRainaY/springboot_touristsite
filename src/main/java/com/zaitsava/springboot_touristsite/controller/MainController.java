package com.zaitsava.springboot_touristsite.controller;

import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private TourRepository tourRepository;

    @GetMapping("/")
    public String mainPageShowTours(Model model) {
        model.addAttribute("tours",tourRepository.findAll());
        return "home/main";
    }
    @GetMapping("/admin/tourList")
    public String adminPageShowTours(Model model) {
        model.addAttribute("tours",tourRepository.findAll());
        return "admin/tourList";
    }
    @RequestMapping("/main")
    public String main() {

        return "redirect:/";
    }
    @RequestMapping("/login")
    public ModelAndView goToLoginPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/login");
        return mv;
    }

}
