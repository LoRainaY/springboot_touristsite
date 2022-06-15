package com.zaitsava.springboot_touristsite.controller;


import javax.validation.Valid;

import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import com.zaitsava.springboot_touristsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");
        return model;
    }

    @PostMapping("/signup")
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "Пользователь с этой электронной почтой уже существует");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {

            userService.saveUser(user);
            model.addObject("msg", "Пользователь успешно зарегистрирован!");
            model.addObject("user", new User());
            model.setViewName("redirect:/");
        }
        return model;
    }


    @GetMapping("/home/main")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

       // model.addObject("userName", "Добрый день,"+user.getFirstname() + " " + user.getLastname()+" "+user.getPatronymic());
        model.setViewName("redirect:/");
        return model;
    }

    @GetMapping("/access_denied")
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
    @GetMapping("/profile")
        public ModelAndView profile() {
            ModelAndView model = new ModelAndView();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            model.addObject("user", user);
            model.setViewName("user/profile");
        return model;
    }


    }