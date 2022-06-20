package com.zaitsava.springboot_touristsite.service;

import com.zaitsava.springboot_touristsite.entity.User;
import org.springframework.stereotype.Component;


public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);

}
