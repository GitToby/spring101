package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
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
    public void run(String... args) throws InterruptedException {
        log.info("Recipes found with findAll():");
        log.info("-------------------------------");
        for (Recipe recipe : recipeRepository.findAll().stream().limit(10).collect(Collectors.toCollection(ArrayList::new))) {
            log.info(String.valueOf(recipe));
        }
    }

}
