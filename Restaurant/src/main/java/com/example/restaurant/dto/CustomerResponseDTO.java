package com.example.restaurant.dto;

import com.example.restaurant.model.Address;
import com.example.restaurant.model.Customer;

public record CustomerResponseDTO(Long id, String name, Address address) {
    public CustomerResponseDTO(Customer customer){
        this(customer.getId(), customer.getName(), customer.getAddress());
    }
}
