package com.zaitsava.springboot_touristsite;

import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.repository.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TourRepositoryTests {
    @Autowired
    private TourRepository tourRepository;

    @Test
    public void getTourByIdTest(){
        Tour tour = tourRepository.findById(5).get();
        assertEquals("Московское путешествие",tour.getTitle());
    }
    @Test
    public void getAllTourTest(){
        List<Tour> tourList = tourRepository.findAll();
        assertEquals(5,tourList.size());
    }
}
