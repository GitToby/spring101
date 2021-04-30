package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
public class ServiceMain implements CommandLineRunner {
    private final Logger LOGGER = LoggerFactory.getLogger(ServiceMain.class);

    @Autowired
    public ServiceMain() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        LOGGER.info("Recipes found with findAll():");
        LOGGER.info("-------------------------------");
//        for (Recipe customer : recipeRepository.findAll().parallelStream().limit(10).collect(Collectors.toCollection(ArrayList::new))) {
//            LOGGER.info(String.valueOf(customer));
//        }
    }

}
