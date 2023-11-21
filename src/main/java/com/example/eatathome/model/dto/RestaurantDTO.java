package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Menu;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.utils.City;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class RestaurantDTO {


    private String name;


    private City city;

    private String pictureUrl;

    private String description;


    public RestaurantDTO() {
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public RestaurantDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RestaurantDTO setDescription(String description) {
        this.description = description;
        return this;
    }


    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
