package com.example.eatathome.model.entity;

import com.example.eatathome.utils.City;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany
    @JsonManagedReference
    private Set<Menu> menu;



    public Restaurant() {
    }


    public String getId() {
        return id;
    }


    public Restaurant setId(String id) {
        this.id = id;
        return this;
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

    public String getDescription() {
        return description;
    }

    public Restaurant setDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonIgnore
    public Set<Menu> getMenu() {
        return menu;
    }

    public Restaurant setMenu(Set<Menu> menu) {
        this.menu = menu;
        return this;
    }
}
