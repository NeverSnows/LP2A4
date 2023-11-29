package com.example.restaurant.controller;

import com.example.restaurant.model.Meal;
import com.example.restaurant.dto.MenuResponseDTO;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping
    public List<MenuResponseDTO> getAll() {
        return menuRepository.findAll().stream().map(MenuResponseDTO::new).toList();
    }

    @PostMapping
    public void addMeal(@RequestBody MenuResponseDTO data){
        menuRepository.save(new Meal(data));
    }

    @DeleteMapping("/{mealId}")
    public void deleteMeal(@PathVariable Long mealId){
        menuRepository.deleteById(mealId);
    }

    @PutMapping("/{mealId}")
    public void editMeal(@PathVariable Long mealId, @RequestBody MenuResponseDTO data){
        Meal meal = new Meal(data);
        meal.setId(mealId);
        menuRepository.save(meal);
    }
}
