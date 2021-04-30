package com.tobydevlin.exmaples.spring101;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    String PASSWORD = System.getenv("MONGO_PASS");

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create(
                String.format("mongodb+srv://foodie:%s@tobytestcluster.uxibf.mongodb.net/foodie?retryWrites=true&w=majority", PASSWORD)
        );
    }
}
