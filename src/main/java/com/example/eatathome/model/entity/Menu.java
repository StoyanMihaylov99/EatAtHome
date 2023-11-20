package com.example.eatathome.model.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne
    private Restaurant restaurant;

    public Menu() {
    }


    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Menu setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Menu setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Menu setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
