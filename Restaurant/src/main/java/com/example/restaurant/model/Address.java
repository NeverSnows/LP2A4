package com.example.restaurant.model;

import com.example.restaurant.dto.AddressResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="addresses")
@Entity(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String street;
    @Column
    private String city;

    public Address(AddressResponseDTO data){
        this.street = data.street();
        this.city = data.city();
    }
}
