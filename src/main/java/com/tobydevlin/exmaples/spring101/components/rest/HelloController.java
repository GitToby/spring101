package com.tobydevlin.exmaples.spring101.components.rest;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Recipe> getRecipes(@RequestParam(required = false) Optional<String> searchStr) {
        // use spring data rest if you want paging
        PageRequest pageable = PageRequest.of(0, 10);
        log.info("{} total pages", recipeRepository.findAll(pageable).getTotalPages());
        log.info("next page: {}", recipeRepository.findAll(pageable).nextOrLastPageable().getPageNumber());
        return searchStr
                .map(s -> recipeRepository.findByTitleLike(s).limit(10).collect(Collectors.toList()))
                .orElse(recipeRepository.findAll(pageable).toList());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    private ResponseEntity<String> handle(MissingServletRequestParameterException e) {
        log.info("", e);
        return new ResponseEntity<>(MessageFormat.format("missing parameter {0}", e.getParameterName()), HttpStatus.BAD_REQUEST);
    }
}