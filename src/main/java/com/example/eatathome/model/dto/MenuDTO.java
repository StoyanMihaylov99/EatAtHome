package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Restaurant;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class MenuDTO {

    private String id;
    @NotNull
    @Size(min = 5)
    private String name;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull

    private Restaurant restaurant;

    public MenuDTO() {
    }

    public String getId() {
        return id;
    }

    public MenuDTO setId(String id) {
        this.id = id;
        return this;
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
