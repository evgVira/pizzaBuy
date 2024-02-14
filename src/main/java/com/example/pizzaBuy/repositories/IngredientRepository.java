package com.example.pizzaBuy.repositories;

import com.example.pizzaBuy.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
