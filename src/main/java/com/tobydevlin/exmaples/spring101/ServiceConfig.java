package com.tobydevlin.exmaples.spring101;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Objects;

@Slf4j
@Configuration
@PropertySource("application.yml")
@EnableMongoRepositories
public class ServiceConfig {

    private final String mongoPassword;

    public ServiceConfig(@Value("${MONGO_PASSWORD}") String mongoPassword) {
        this.mongoPassword = mongoPassword;
        if (Objects.equals(this.mongoPassword, "")) {
            log.error("No Mongo password discovered!");
        }
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
