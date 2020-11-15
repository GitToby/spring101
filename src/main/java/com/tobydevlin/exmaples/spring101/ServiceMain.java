package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
public class ServiceMain implements CommandLineRunner {
    private final RecipeRepository recipeRepository;

    @Autowired
    public ServiceMain(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Recipe myR = Recipe.builder().host("test 1234").build();
//        recipeRepository.insert(myR);
        System.out.println("Recipes found with findAll():");
        System.out.println("-------------------------------");
        for (Recipe customer : recipeRepository.findAll().stream().limit(10).collect(Collectors.toCollection(ArrayList::new))) {
            System.out.println(customer);
        }
    }
}
