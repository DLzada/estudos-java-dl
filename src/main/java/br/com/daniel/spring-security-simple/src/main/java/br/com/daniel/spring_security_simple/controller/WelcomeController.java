package br.com.daniel.spring_security_simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Welcome Controller
@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }
    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }
}