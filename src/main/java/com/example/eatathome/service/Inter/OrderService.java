package com.example.eatathome.service.Inter;

import com.example.eatathome.model.dto.CustomerDTO;
import com.example.eatathome.model.dto.OrderDTO;
import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderDTO> getOrderById(String id);
    List<OrderDTO> getOrdersByRestaurant(String restaurantId);
    List<OrderDTO> getOrdersByCustomer(String id);

    void deleteOrderById(String id);
    String createOrder(OrderDTO orderDTO);

    Optional<OrderDTO> updateOrder(OrderDTO orderDTO);

}
