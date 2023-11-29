package com.example.restaurant.dto;

import com.example.restaurant.model.Employee;

public record EmployeesResponseDTO(Long id, String name, String cpf) {
    public EmployeesResponseDTO(Employee employee){
        this(employee.getId(), employee.getName(), employee.getCpf());
    }
}
