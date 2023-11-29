package com.example.restaurant.model;

import com.example.restaurant.dto.MenuResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meals")
@Entity(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private MealType type;

    public Meal(MenuResponseDTO data){
        this.name = data.name();
        this.description = data.description();
        this.type = data.type();
        this.price = data.price();
    }


}
