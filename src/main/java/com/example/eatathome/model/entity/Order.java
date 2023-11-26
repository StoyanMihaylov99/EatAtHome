package com.example.eatathome.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @ManyToOne
    private Restaurant restaurant;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @ManyToOne
    private Customer customer;


    public Order() {
    }

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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }


    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Order setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", DateCreatedOrder=" + DateCreatedOrder +
                ", restaurant=" + restaurant +
                ", totalCost=" + totalCost +
                ", customer=" + customer +
                '}';
    }
}
