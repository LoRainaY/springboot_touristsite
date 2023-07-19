package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryPDF extends JpaRepository<User,Long> {
}
