package com.example.pizzaBuy.controllers;
import com.example.pizzaBuy.models.Pizza;
import com.example.pizzaBuy.models.PizzaOrder;
import com.example.pizzaBuy.repositories.OrderRepository;
import com.example.pizzaBuy.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/pizzas", produces = "application/json")
@CrossOrigin(origins = "http://pizzaBuy:8080")
public class PizzaController {
    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;
    @Autowired
    PizzaController(PizzaRepository pizzaRepository, OrderRepository orderRepository){
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }
    @GetMapping
    public Iterable<Pizza> findPizza(){
        return pizzaRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> findById(@PathVariable(name = "id")Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizzaRepository.findById(id).isPresent()){
            return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza postPizza(@RequestBody Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    @PutMapping(path="/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public PizzaOrder putOrder(@PathVariable(name = "id")Long id,
                               @RequestBody PizzaOrder pizzaOrder){
        pizzaOrder.setId(id);
        return orderRepository.save(pizzaOrder);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public PizzaOrder patchOrder(@PathVariable(name = "id")Long id,
                                 @RequestBody PizzaOrder pizzaOrder){
        PizzaOrder order = orderRepository.findById(id).get();
        if(pizzaOrder.getDeliveryName() != null){
            order.setDeliveryName(pizzaOrder.getDeliveryName());
        }
        if(pizzaOrder.getDeliveryStreet() != null){
            order.setDeliveryStreet(pizzaOrder.getDeliveryStreet());
        }
        if(pizzaOrder.getDeliveryCity() != null){
            order.setDeliveryCity(pizzaOrder.getDeliveryCity());
        }
        if(pizzaOrder.getDeliveryPhone() != null){
            order.setDeliveryPhone(pizzaOrder.getDeliveryPhone());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteOrder(@PathVariable Long id){
        try {
            orderRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
