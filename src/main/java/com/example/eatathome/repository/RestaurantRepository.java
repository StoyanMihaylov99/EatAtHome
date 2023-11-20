package com.example.eatathome.repository;

import com.example.eatathome.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<String, Restaurant> {
}
