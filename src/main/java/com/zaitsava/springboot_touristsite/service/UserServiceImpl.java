package com.zaitsava.springboot_touristsite.service;

import com.zaitsava.springboot_touristsite.entity.Role;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.RoleRepository;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import com.zaitsava.springboot_touristsite.repository.UserRepositoryPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {

        List<User> list=userRepository.findAll();
        Role userRole;
        if(list.size()==0){
            userRole = roleRepository.findByRole("ADMIN");
        }
        else {
            userRole = roleRepository.findByRole("USER");
        }
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        userRepository.save(user);
    }

}