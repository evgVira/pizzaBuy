package com.example.pizzaBuy.controllers;

import com.example.pizzaBuy.models.PizzaOrder;
import com.example.pizzaBuy.models.User;
import com.example.pizzaBuy.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@RequestMapping("/orders")
@Controller
@Slf4j
@SessionAttributes("pizzaOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid PizzaOrder pizzaOrder, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        pizzaOrder.setUser(user);
        log.info("Order submitted: {}", pizzaOrder);
        sessionStatus.setComplete();
        return "successOrder";
    }
}
