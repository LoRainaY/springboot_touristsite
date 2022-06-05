package com.zaitsava.springboot_touristsite.entity;

import com.zaitsava.springboot_touristsite.OrderStatusEnum;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "sorder")
@Entity
public class Order {
    public Order() {
    }

    public Order(User user, Tour tour,Integer count) {
        this.user = user;
        this.tour = tour;
        this.count=count;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(columnDefinition = "user_id",nullable = false)
    private User user;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(columnDefinition = "tour_id",nullable = false)
    private Tour tour;

    @Column(columnDefinition = "integer default 0")
    private OrderStatusEnum status;

    private Integer discountPrice;


    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count;


    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }


    @CreatedDate
    @Column(name = "date")
    private LocalDateTime date;


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
