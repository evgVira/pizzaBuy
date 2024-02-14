package com.example.pizzaBuy.controllers;

import com.example.pizzaBuy.models.Ingredient;
import com.example.pizzaBuy.models.Ingredient.Type;
import com.example.pizzaBuy.models.Pizza;
import com.example.pizzaBuy.models.PizzaOrder;
import com.example.pizzaBuy.repositories.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
/*
    Объявляем объект pizzaOrder на уровне сеанса,
    так как будем его использовать в дальнейшем в других запросах
*/
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {
    private final IngredientRepository ingredientRepository;
    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Type[] types = Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredientRepository.findAll(), type));
        }
    }
    @ModelAttribute(name = "pizza")
    public Pizza pizza(){
        return new Pizza();
    }
    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder pizzaOrder(){
        return new PizzaOrder();
    }

    @GetMapping
    public String designForm(){
        return "design";
    }
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
    @PostMapping
    public String processPizza(@Valid Pizza pizza, Errors errors, @ModelAttribute PizzaOrder pizzaOrder){
        if(errors.hasErrors()){
            return "design";
        }
        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza : {}", pizza);
        return "redirect:/orders/current";
    }
}
