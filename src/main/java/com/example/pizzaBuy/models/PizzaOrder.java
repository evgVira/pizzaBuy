package com.example.pizzaBuy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    private Date placedAt;
    @NotBlank(message = "delivery name is required")
    private String deliveryName;
    @NotBlank(message = "delivery street is required")
    private String deliveryStreet;
    @NotBlank(message = "delivery city is required")
    private String deliveryCity;
    @NotBlank(message = "delivery phone is required")
    private String deliveryPhone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }
}
