package com.example.pizzaBuy.repositories;

import com.example.pizzaBuy.models.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {
}
