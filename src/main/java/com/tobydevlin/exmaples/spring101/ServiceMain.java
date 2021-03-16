package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
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
        log.info("{} recipes found during startup", recipeRepository.count());
    }
}
