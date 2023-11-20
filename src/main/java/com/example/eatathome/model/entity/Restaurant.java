package com.example.eatathome.model.entity;

import com.example.eatathome.utils.City;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "restaurant")
    private Set<Menu> menu;
    @OneToMany(mappedBy = "restaurant")
    private Set<Order> orders;

    public Restaurant() {
    }


    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Restaurant setCity(City city) {
        this.city = city;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public Restaurant setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Restaurant setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public Restaurant setMenu(Set<Menu> menu) {
        this.menu = menu;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Restaurant setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
