package com.example.pizzaBuy;

import com.example.pizzaBuy.models.Ingredient;
import com.example.pizzaBuy.repositories.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PizzaBuyApplication {
	public static void main(String[] args) {
		SpringApplication.run(PizzaBuyApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repository.save(new Ingredient("PEP", "Pepperoni", Ingredient.Type.PROTEIN));
				repository.save(new Ingredient("CAH", "Cheese and ham", Ingredient.Type.PROTEIN));
				repository.save(new Ingredient("MET", "Meat", Ingredient.Type.PROTEIN));
				repository.save(new Ingredient("CHC", "Chicken and cheese", Ingredient.Type.CHEESE));
				repository.save(new Ingredient("FOC", "Four cheese", Ingredient.Type.CHEESE));
				repository.save(new Ingredient("CHE", "Cheese", Ingredient.Type.CHEESE));
				repository.save(new Ingredient("MAR", "Margaritta", Ingredient.Type.VEGGIES));
				repository.save(new Ingredient("MUS", "Mushrooms", Ingredient.Type.MUSHROOMS));
				repository.save(new Ingredient("HAM", "Ham and mushrooms", Ingredient.Type.MUSHROOMS));
			}
		};
	}
}
