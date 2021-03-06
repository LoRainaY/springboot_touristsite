package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public User findById(Integer id);
}
