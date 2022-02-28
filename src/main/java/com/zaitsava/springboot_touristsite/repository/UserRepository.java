package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public User findByPhone(String phone);
}
