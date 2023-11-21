package com.example.eatathome.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToMany
    private Set<Menu> menu;
    @Transient
    private List<String> addresses;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public User setMenu(Set<Menu> menu) {
        this.menu = menu;
        return this;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public User setAddresses(List<String> addresses) {
        this.addresses = addresses;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
