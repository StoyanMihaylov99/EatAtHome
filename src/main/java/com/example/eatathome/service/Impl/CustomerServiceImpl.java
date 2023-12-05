package com.example.eatathome.service.Impl;

import com.example.eatathome.model.dto.CustomerDTO;
import com.example.eatathome.model.dto.OrderDTO;
import com.example.eatathome.model.entity.Customer;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.repository.CustomerRepository;
import com.example.eatathome.service.Inter.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(String id) {
        return this.customerRepository.findById(id).map(this::asDTO);
    }


    private CustomerDTO asDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public void deleteUserById(String id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public String createCustomer(CustomerDTO customerDTO) {
        Customer newCustomer = new Customer().setId(UUID.randomUUID().toString()).setCity(customerDTO.getCity()).setAddress(customerDTO.getAddress()).
                setEmail(customerDTO.getEmail()).setOrders(customerDTO.getOrders()).setFirstName(customerDTO.getFirstName()).setLastName(customerDTO.getLastName()).
                setPhoneNumber(customerDTO.getPhoneNumber());
        return this.customerRepository.save(newCustomer).getId();

    }

    @Override
    public Optional<CustomerDTO> updateCustomer(CustomerDTO customerDTO) {
        if(!this.customerRepository.existsById(customerDTO.getId())){
            throw new EntityNotFoundException("Entity with ID " + customerDTO.getId() + " not found");
        }

        this.customerRepository.save(modelMapper.map(customerDTO,Customer.class));
        return this.customerRepository.findById(customerDTO.getId()).map(this::asDTO);
    }
}
