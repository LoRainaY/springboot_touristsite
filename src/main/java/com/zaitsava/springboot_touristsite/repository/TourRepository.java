package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Integer> {
    List<Tour> findAll();
}
