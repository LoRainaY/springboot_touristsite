package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


    @Modifying
    @Query(value = "DELETE FROM order where id= :id",nativeQuery = true)
    void deleteOrderById(@Param("id")Long id);
}
