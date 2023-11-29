package com.example.restaurant.model;

import com.example.restaurant.dto.EmployeesResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String cpf;

    public Employee(EmployeesResponseDTO data){
        this.name = data.name();
        this.cpf = data.cpf();
    }
}
