package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Restaurant;
import com.example.eatathome.model.entity.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {


    private String id;

    private LocalDateTime DateCreatedOrder;

    private Restaurant restaurant;

    private User user;

    private BigDecimal totalCost;

    public OrderDTO() {
    }

    public String getId() {
        return id;
    }

    public OrderDTO setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDateCreatedOrder() {
        return DateCreatedOrder;
    }

    public OrderDTO setDateCreatedOrder(LocalDateTime dateCreatedOrder) {
        DateCreatedOrder = dateCreatedOrder;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public OrderDTO setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public OrderDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public OrderDTO setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }
}
