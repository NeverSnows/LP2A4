package com.example.restaurant.repository;

import com.example.restaurant.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Meal, Long> {
}
