package com.example.pizzaBuy.controllers;

import com.example.pizzaBuy.RegistrationForm;
import com.example.pizzaBuy.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registerForm")
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String registerForm(){
        return "registerForm";
    }
    @PostMapping
    public String processRegister(RegistrationForm registerForm){
        userRepository.save(registerForm.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
