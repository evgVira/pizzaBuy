package com.example.pizzaBuy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RestResource(rel = "pizzas", path = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @ManyToMany()
    private List<Ingredient> ingredients;
}
