package com.example.restaurant.controller;

import com.example.restaurant.dto.OrderResponseDTO;
import com.example.restaurant.model.Order;
import com.example.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<OrderResponseDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderResponseDTO::new).toList();
    }

    @PostMapping
    public void addOrder(@RequestBody OrderResponseDTO data){
        orderRepository.save(new Order(data));
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        orderRepository.deleteById(orderId);
    }

    @PutMapping("/{orderId}")
    public void editOrder(@PathVariable Long orderId, @RequestBody OrderResponseDTO data){
        Order order = new Order(data);
        order.setId(orderId);
        orderRepository.save(order);
    }
}
