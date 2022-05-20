package com.zaitsava.springboot_touristsite.service;

import com.zaitsava.springboot_touristsite.entity.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
    public User findByPhone(String phone);
    public User findById(Integer id);
}
