package com.example.eatathome.service.Inter;

import com.example.eatathome.model.dto.CustomerDTO;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerDTO> getCustomerById(String id);
    void deleteUserById(String id);
    String createCustomer(CustomerDTO customerDTO);
    Optional<CustomerDTO> updateCustomer(CustomerDTO customerDTO);
}
