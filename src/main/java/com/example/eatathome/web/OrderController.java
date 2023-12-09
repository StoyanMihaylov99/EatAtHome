package com.example.eatathome.web;
import com.example.eatathome.model.dto.OrderDTO;
import com.example.eatathome.service.Inter.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//TODO testing all requests.


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable("id") String id){
        Optional<OrderDTO> orderById = this.orderService.getOrderById(id);
        if(orderById.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(orderById.get());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderDTO>> getByCustomer(@PathVariable("id") String customerId){
      List<OrderDTO> ordersByCustomer = this.orderService.getOrdersByCustomer(customerId);
      if(ordersByCustomer.isEmpty()) return ResponseEntity.notFound().build();
      return ResponseEntity.ok(ordersByCustomer);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO, UriComponentsBuilder uriComponentsBuilder){
        String orderId = this.orderService.createOrder(orderDTO);
        URI location = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(orderId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable("id") String id, @RequestBody OrderDTO updatedOrder){
        updatedOrder.setId(id);
        Optional<OrderDTO> newOrder = this.orderService.updateOrder(updatedOrder);
        return ResponseEntity.ok(newOrder.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("id") String id) {
        this.orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }
}
