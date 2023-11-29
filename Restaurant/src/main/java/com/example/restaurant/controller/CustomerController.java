package com.example.restaurant.controller;

import com.example.restaurant.dto.CustomerResponseDTO;
import com.example.restaurant.model.Customer;
import com.example.restaurant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<CustomerResponseDTO> getAll() {
        return customerRepository.findAll().stream().map(CustomerResponseDTO::new).toList();
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerResponseDTO data){
        customerRepository.save(new Customer(data));
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerRepository.deleteById(customerId);
    }

    @PutMapping("/{customerId}")
    public void editCustomer(@PathVariable Long customerId, @RequestBody CustomerResponseDTO data){
        Customer customer = new Customer(data);
        customer.setId(customerId);
        customerRepository.save(customer);
    }
}
