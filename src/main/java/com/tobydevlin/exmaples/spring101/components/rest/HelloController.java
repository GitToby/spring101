package com.tobydevlin.exmaples.spring101.components.rest;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@RestController("/api")
public class HelloController {
    private final RecipeRepository recipeRepository;

    public HelloController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/recipes")
    public List<Recipe> getRecipes(@RequestParam() String searchStr) {
        return recipeRepository.findByTitleLike(searchStr);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    private ResponseEntity<String> handle(MissingServletRequestParameterException e) {
        log.info("", e);
        return new ResponseEntity<>(MessageFormat.format("missing parameter {0}", e.getParameterName()), HttpStatus.BAD_REQUEST);
    }
}