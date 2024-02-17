package com.example.pizzaBuy.repositories;

import com.example.pizzaBuy.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
