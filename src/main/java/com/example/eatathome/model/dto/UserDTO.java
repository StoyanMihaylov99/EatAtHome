package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Restaurant;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserDTO {

    private String id;
    @Size(min = 3, max = 12, message = "Invalid first name")
    private String firstName;
    @Size(min = 3, max = 12, message = "Invalid last name")
    private String lastName;
    @Email
    private String email;
    @Size(min = 3, max = 25, message = "Invalid password")
    private String password;

    private Set<Restaurant> restaurants;

    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public UserDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public UserDTO setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }
}
