package com.example.pizzaBuy.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {
    @NotBlank(message = "delivery name is required")
    private String deliveryName;
    @NotBlank(message = "delivery street is required")
    private String deliveryStreet;
    @NotBlank(message = "delivery city is required")
    private String deliveryCity;
    @NotBlank(message = "delivery phone is required")
    private String deliveryPhone;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
}
