package com.tobydevlin.exmaples.spring101.components.rest;

import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/test")
    public Recipe getRestaurant() {
        return Recipe.builder().title("new recipe").build();

    }

}