package com.tobydevlin.exmaples.spring101.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Review {
    private String reviewText;
    private int rating;
}

