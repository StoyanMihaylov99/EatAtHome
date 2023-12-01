package com.example.eatathome.service.Impl;

import com.example.eatathome.model.dto.CustomerDTO;
import com.example.eatathome.model.dto.OrderDTO;
import com.example.eatathome.model.entity.Customer;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.repository.CustomerRepository;
import com.example.eatathome.service.Inter.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<CustomerDTO> getCustomerById(String id){
        return this.customerRepository.findById(id).map(this::asDTO);
    }


    private CustomerDTO asDTO(Customer customer) {
        return modelMapper.map(customer,CustomerDTO.class);
    }
}
