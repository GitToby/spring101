package com.tobydevlin.exmaples.spring101.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.MongoDriverInformation;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ServiceConfig {

    private final String mongoPassword;

    public ServiceConfig(@Value("${secrets.mongo_pw}") String mongoPassword) {
        this.mongoPassword = mongoPassword;
    }

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://foodie:" + mongoPassword + "@tobytestcluster.uxibf.mongodb.net/?retryWrites=true&w=majority");
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "foodie");
    }

}
