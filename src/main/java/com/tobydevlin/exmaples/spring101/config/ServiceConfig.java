package com.tobydevlin.exmaples.spring101.config;

import com.mongodb.MongoDriverInformation;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://foodie:@tobytestcluster.uxibf.mongodb.net/foodie?retryWrites=true&w=majority");
    }
}
