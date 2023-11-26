package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Restaurant;

import java.math.BigDecimal;

public class MenuDTO {


    private String name;

    private String description;

    private BigDecimal price;

    private Restaurant restaurant;

    public MenuDTO() {
    }

    public String getName() {
        return name;
    }

    public MenuDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MenuDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public MenuDTO setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
