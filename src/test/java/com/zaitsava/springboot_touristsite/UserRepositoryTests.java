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
    public void findByEmailTest(){
        User user=userRepository.findByEmail("angels1070@gmail.com");
        Integer userId=user.getId();
        assertEquals(2,userId);
    }
    @Test
    public void findByIdTest(){
        User user=userRepository.findById(3);
        String firstName=user.getFirstname();
        String lastName=user.getLastname();
        String patronymic=user.getPatronymic();
        assertEquals("Никола",firstName);
        assertEquals("Петров",lastName);
        assertEquals("Иванович",patronymic);
    }
    @Test
    public void saveUserTest(){

        userService.saveUser(getUser());
        User userAct=userRepository.findById(53);
        assertEquals("yakov83@mail.com",userAct.getEmail());
    }

    private User getUser() {
        User user = new User();
        user.setFirstname("Маргарита");
        user.setLastname("Яковлева");
        user.setPatronymic("Ивановна");
        user.setEmail("yakov83@mail.com");
        user.setPassword("UsRe107066");
        user.setPhone("+375449873480");
        return user;
    }
}
