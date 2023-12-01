package com.example.eatathome.repository;

import com.example.eatathome.model.entity.Customer;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    List<Order> findAllByRestaurant(Restaurant restaurant);
    List<Order> findAllByCustomer(Customer customer);
}
