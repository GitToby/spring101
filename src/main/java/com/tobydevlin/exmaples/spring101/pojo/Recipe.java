package com.tobydevlin.exmaples.spring101.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.MessageFormat;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document("scrapes")
public class Recipe {
    @Id
    private String id;
    private String url;
    private String host;
    private String title;
    private int total_time;
    private String image;
    private List<String> ingredients;
    private String instructions;
    private String ratings;
    private List<Review> reviews;
    private String locale;
    private String scrape_time;
}
