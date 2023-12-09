package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Order;
import com.example.eatathome.utils.City;
import com.example.eatathome.utils.EnumValidator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class CustomerDTO {

    private String id;

    @Size(min = 3, max = 20)
    @NotNull
    private String firstName;
    @Size(min = 3, max = 20)
    @NotNull
    private String lastName;
    @EnumValidator(enumClass = City.class)
    private City city;
    @Size(min = 5, max = 40)
    @NotNull
    private String address;
    @NotNull
    @Size(min = 10, max = 10)
    //TODO Validation problem
    private String phoneNumber;
    @Email
    private String email;

    private Set<Order> orders;

    public CustomerDTO() {
    }

    public String getId() {
        return id;
    }

    public CustomerDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public City getCity() {
        return city;
    }

    public CustomerDTO setCity(City city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        return orders;
    }

    public CustomerDTO setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
