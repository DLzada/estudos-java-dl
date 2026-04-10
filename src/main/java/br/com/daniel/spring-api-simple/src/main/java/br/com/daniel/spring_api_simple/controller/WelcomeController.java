package br.com.daniel.spring_api_simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String Welcome(){
        return "Seja bem vindo";
    }
}
