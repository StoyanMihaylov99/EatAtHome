package com.example.eatathome.service.Impl;

import com.example.eatathome.model.dto.CustomerDTO;
import com.example.eatathome.model.dto.OrderDTO;
import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.model.entity.Customer;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.model.entity.Restaurant;
import com.example.eatathome.repository.OrderRepository;
import com.example.eatathome.service.Inter.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<OrderDTO> getOrderById(String id) {
        return this.orderRepository.findById(id).map(this::asDTO);
    }

    @Override
    public List<OrderDTO> getOrdersByRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant currentRestaurant = modelMapper.map(restaurantDTO,Restaurant.class);
        return this.orderRepository.findAllByRestaurant(currentRestaurant).stream().map(this::asDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByCustomer(CustomerDTO customerDTO) {
        Customer currentCustomer = modelMapper.map(customerDTO,Customer.class);
        return this.orderRepository.findAllByCustomer(currentCustomer).stream().map(this::asDTO).collect(Collectors.toList());
    }


    @Override
    public void deleteOrderById(String id) {
        this.orderRepository.deleteById(id);

    }

    @Override
    public String createOrder(OrderDTO orderDTO) {
        Order newOrder = new Order().setId(UUID.randomUUID().toString()).setRestaurant(orderDTO.getRestaurant()).setTotalCost(orderDTO.getTotalCost()).
                setDateCreatedOrder(orderDTO.getDateCreatedOrder());
        return this.orderRepository.save(newOrder).getId();
    }

    @Override
    public Optional<OrderDTO> updateOrder(OrderDTO orderDTO) {
        if(!this.orderRepository.existsById(orderDTO.getId())){
            throw new EntityNotFoundException("Entity with ID " + orderDTO.getId() + " not found");
        }

        this.orderRepository.save(modelMapper.map(orderDTO,Order.class));
        return this.orderRepository.findById(orderDTO.getId()).map(this::asDTO);
    }

    private OrderDTO asDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }
}
