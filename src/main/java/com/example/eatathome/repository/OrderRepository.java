package com.example.eatathome.repository;

import com.example.eatathome.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<String, Order> {
}
