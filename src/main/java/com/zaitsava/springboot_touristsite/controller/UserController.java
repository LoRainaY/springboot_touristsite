package com.zaitsava.springboot_touristsite.controller;


import javax.validation.Valid;

import com.zaitsava.springboot_touristsite.entity.Role;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.RoleRepository;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import com.zaitsava.springboot_touristsite.service.UserService;
import com.zaitsava.springboot_touristsite.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");
        return model;
    }
    @PostMapping("/changeUser")
    public String change(@ModelAttribute(name = "user") User user, @RequestParam("idU")Integer id,
                         @RequestParam("firstname")String firstName,
                         @RequestParam("lastname")String lastName,
                         @RequestParam("patronymic")String patronymic,
                         @RequestParam("email")String email,
                         @RequestParam("phone")String phone,
                         @RequestParam("bonus") String string) {
        user=userRepository.findById(id);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setPatronymic(patronymic);
        user.setEmail(email);
        user.setPhone(phone);
        System.out.println("Bonus "+string);
        if(string.equals("true"))
        user.setGetBonus(true);

        userRepository.save(user);
        return "redirect:admin/userList";
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