package com.zaitsava.springboot_touristsite;

import com.zaitsava.springboot_touristsite.entity.CartItem;
import com.zaitsava.springboot_touristsite.entity.User;
import com.zaitsava.springboot_touristsite.repository.UserRepository;
import com.zaitsava.springboot_touristsite.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired(required=true)
    private UserServiceImpl userService;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByEmailTest(){  // поиск по email
        User user=userRepository.findByEmail("angels1070@gmail.com");
        Integer userId=user.getId();
        assertEquals(2,userId);
    }
    @Test
    public void findByIdTest(){ // поиск по id
        User user=userRepository.findById(3);
        String firstName=user.getFirstname();
        String lastName=user.getLastname();
        String patronymic=user.getPatronymic();
        assertEquals("Никола",firstName);
        assertEquals("Петров",lastName);
        assertEquals("Иванович",patronymic);
    }
}
