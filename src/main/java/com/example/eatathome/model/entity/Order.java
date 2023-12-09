package com.example.eatathome.model.entity;

import com.example.eatathome.utils.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


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
    @JsonManagedReference
    private Customer customer;
    @ManyToMany
    @Column(name = "menu_id")
    private List<Menu> items;
    @ManyToMany(mappedBy = "orders")
    private List<Restaurant> restaurants;
    @Enumerated(EnumType.STRING)
    private City city;



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


    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Order setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public List<Menu> getItems() {
        return items;
    }

    public Order setItems(List<Menu> items) {
        this.items = items;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Order setCity(City city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Order setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", DateCreatedOrder=" + DateCreatedOrder +
                ", totalCost=" + totalCost +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                ", items=" + items +
                ", city=" + city +
                '}';
    }
}
