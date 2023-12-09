package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Customer;
import com.example.eatathome.model.entity.Menu;
import com.example.eatathome.model.entity.Restaurant;
import com.example.eatathome.utils.City;
import com.example.eatathome.utils.EnumValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class OrderDTO {
    private String id;
    @NotNull
    private LocalDateTime DateCreatedOrder;
    private String address;
    @NotNull
    private BigDecimal totalCost;
    @NotNull
    private Customer customer;
    @EnumValidator(enumClass = City.class)
    private City city;
    private List<Menu> items;

    private List<Restaurant> restaurantSet;

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

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public OrderDTO setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderDTO setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public City getCity() {
        return city;
    }

    public OrderDTO setCity(City city) {
        this.city = city;
        return this;
    }

    public List<Menu> getItems() {
        return items;
    }

    public OrderDTO setItems(List<Menu> items) {
        this.items = items;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<Restaurant> getRestaurantSet() {
        return restaurantSet;
    }

    public OrderDTO setRestaurantSet(List<Restaurant> restaurantSet) {
        this.restaurantSet = restaurantSet;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", DateCreatedOrder=" + DateCreatedOrder +
                ", totalCost=" + totalCost +
                ", customer=" + customer +
                ", city=" + city +
                '}';
    }
}
