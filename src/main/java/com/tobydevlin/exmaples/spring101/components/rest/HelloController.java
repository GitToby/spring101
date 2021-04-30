package com.tobydevlin.exmaples.spring101.components.rest;

import com.tobydevlin.exmaples.spring101.pojo.HelloName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    public String index() {
        log.info("Index!");
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    public HelloName helloName(@PathVariable("name") String name) {
        log.info("Saying hi to {}", name);
        return new HelloName(name);
    }
}