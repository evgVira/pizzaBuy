package com.example.pizzaBuy.controllers;

import com.example.pizzaBuy.models.Ingredient;
import com.example.pizzaBuy.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(name = "/api/ingredients", consumes = "application/json")
@CrossOrigin(origins = "http://localhos:8080")
public class IngredientController {
    private final IngredientRepository ingredientRepository;

    @Autowired
    IngredientController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)

    public Iterable<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient postIngredient(@RequestBody Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteIngredient(@PathVariable(name = "id")String id){
        ingredientRepository.deleteById(id);
    }

}
