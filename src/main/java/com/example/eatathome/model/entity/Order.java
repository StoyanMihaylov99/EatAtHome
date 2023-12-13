package com.example.eatathome.model.entity;

import com.example.eatathome.utils.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order{

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "date_of_created_order")
    private LocalDateTime DateCreatedOrder;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Column(name = "address")
    private String address;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    private Set<Menu> menu;
    @ManyToMany
    private Set<Restaurant> restaurants;
    @Enumerated(EnumType.STRING)
    private City city;

    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDateCreatedOrder() {
        return DateCreatedOrder;
    }

    public Order setDateCreatedOrder(LocalDateTime dateCreatedOrder) {
        DateCreatedOrder = dateCreatedOrder;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Order setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public Order setMenu(Set<Menu> menu) {
        this.menu = menu;
        return this;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Order setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Order setCity(City city) {
        this.city = city;
        return this;
    }
}
