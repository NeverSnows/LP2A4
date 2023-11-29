package com.example.restaurant.dto;

import com.example.restaurant.model.Address;

public record AddressResponseDTO(Long id, String street, String city) {
    public AddressResponseDTO(Address address){
        this(address.getId(), address.getStreet(), address.getCity());
    }
}
