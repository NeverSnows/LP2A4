package com.example.restaurant.dto;

import com.example.restaurant.model.Order;

public record OrderResponseDTO(Long id, String description) {
    public OrderResponseDTO(Order order){
        this(order.getId(), order.getDescription());
    }
}
