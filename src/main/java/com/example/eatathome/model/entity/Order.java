package com.example.eatathome.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "date_of_created_order")
    private LocalDateTime DateCreatedOrder;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private User user;
    @Column(name = "total_cost")
    private BigDecimal totalCost;


    public Order() {
    }

    public LocalDateTime getDateCreatedOrder() {
        return DateCreatedOrder;
    }

    public Order setDateCreatedOrder(LocalDateTime dateCreatedOrder) {
        DateCreatedOrder = dateCreatedOrder;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Order setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }
}
