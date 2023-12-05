package com.example.eatathome.web;


import com.example.eatathome.model.dto.CustomerDTO;
import com.example.eatathome.service.Impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;


    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") String id){
        Optional<CustomerDTO> customer = this.customerService.getCustomerById(id);
        if(customer.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer.get());
    }

    @PutMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO, UriComponentsBuilder uriComponentsBuilder){
        String CustomerId = this.customerService.createCustomer(customerDTO);
        URI location = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(CustomerId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") String id,@RequestBody CustomerDTO customerToUpdate){
        customerToUpdate.setId(id);
        Optional<CustomerDTO> updatedCustomer = this.customerService.updateCustomer(customerToUpdate);
        return ResponseEntity.ok(updatedCustomer.get());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") String id){
        this.customerService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
