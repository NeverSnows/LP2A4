package com.example.restaurant.controller;

import com.example.restaurant.dto.AddressResponseDTO;
import com.example.restaurant.model.Address;
import com.example.restaurant.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public List<AddressResponseDTO> getAll() {
        return addressRepository.findAll().stream().map(AddressResponseDTO::new).toList();
    }

    @PostMapping
    public void addAddress(@RequestBody AddressResponseDTO data){
        addressRepository.save(new Address(data));
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable Long addressId){
        addressRepository.deleteById(addressId);
    }

    @PutMapping("/{addressId}")
    public void editAddress(@PathVariable Long addressId, @RequestBody AddressResponseDTO data){
        Address address = new Address(data);
        address.setId(addressId);
        addressRepository.save(address);
    }
}
