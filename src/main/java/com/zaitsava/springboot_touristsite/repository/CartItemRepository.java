package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.CartItem;
import com.zaitsava.springboot_touristsite.entity.Tour;
import com.zaitsava.springboot_touristsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    public List<CartItem> findByUser(User user);

    public CartItem findByUserAndTour(User user, Tour tour);

    @Query("delete from CartItem c where c.user.id=?1 and c.tour.id=?1")
    @Modifying
    public void deleteByUserAndTour(Integer userId, Integer tourId);



}
