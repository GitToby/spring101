package com.tobydevlin.exmaples.spring101.components.data;

import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findByTitleLike(String s);
}
