package com.example.pizzaBuy.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class Pizza {
    @NotNull
    private String name;
    @NotNull
    private List<Ingredient> ingredients;

}
