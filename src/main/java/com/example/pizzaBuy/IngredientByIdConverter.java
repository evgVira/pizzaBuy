package com.example.pizzaBuy;

import com.example.pizzaBuy.models.Ingredient;
import com.example.pizzaBuy.models.Ingredient.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();
    public IngredientByIdConverter(){
        ingredientMap.put("PEP", new Ingredient("PEP","Pepperoni", Type.PEPPERONI));
        ingredientMap.put("CHE", new Ingredient("CHE", "Cheese", Type.CHEESE));
        ingredientMap.put("VEG", new Ingredient("VEG", "Veggies", Type.VEGGIES));
        ingredientMap.put("SAU", new Ingredient("SAU", "Sauce", Type.SAUCE));
    }
    @Override
    public Ingredient convert(String id){
        return ingredientMap.get(id);
    }
}
