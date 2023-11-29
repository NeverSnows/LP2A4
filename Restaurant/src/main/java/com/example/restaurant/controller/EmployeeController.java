package com.example.restaurant.controller;

import com.example.restaurant.model.Employee;
import com.example.restaurant.dto.EmployeesResponseDTO;
import com.example.restaurant.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeesResponseDTO> getAll() {
        return employeeRepository.findAll().stream().map(EmployeesResponseDTO::new).toList();
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeesResponseDTO data){
        employeeRepository.save(new Employee(data));
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void editEmployee(@PathVariable Long employeeId, @RequestBody EmployeesResponseDTO data){
        Employee employee = new Employee(data);
        employee.setId(employeeId);
        employeeRepository.save(employee);
    }
}
