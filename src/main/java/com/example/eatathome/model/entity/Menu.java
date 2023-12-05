package com.example.eatathome.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;


@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Restaurant restaurant;

    public Menu() {
    }


    public String getId() {
        return id;
    }


    public Menu setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Menu setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Menu setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @JsonIgnore

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Menu setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
