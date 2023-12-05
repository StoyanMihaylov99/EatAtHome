package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Menu;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.utils.City;
import com.example.eatathome.utils.EnumValidator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class RestaurantDTO {

    private String id;
    @Size(min = 3, max = 12, message = "name")
    private String name;

    @EnumValidator(enumClass = City.class)
    private City city;
    @NotNull
    private String description;

    private Set<Menu> menu;


    public RestaurantDTO() {
    }

    public String getId() {
        return id;
    }

    public RestaurantDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantDTO setName(String name) {
        this.name = name;
        return this;
    }

    public City getCity() {
        return city;
    }

    public RestaurantDTO setCity(City city) {
        this.city = city;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RestaurantDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public RestaurantDTO setMenu(Set<Menu> menu) {
        this.menu = menu;
        return this;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", pictureUrl='" + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
