package com.tobydevlin.exmaples.spring101;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.text.MessageFormat;

@Slf4j
@Configuration
@EnableMongoRepositories
public class ServiceConfig {

    private final String mongoPassword;
    private final String mongoUser;
    private final String mongoHost;
    private final String mongoDatabase;

    public ServiceConfig(@Value("${MONGO_PASSWORD}") String mongoPassword,
                         @Value("${MONGO_USER}") String mongoUser,
                         @Value("${data.mongo.host}") String mongoHost,
                         @Value("${data.mongo.database}") String mongoDatabase) {
        this.mongoPassword = mongoPassword;
        this.mongoUser = mongoUser;
        this.mongoHost = mongoHost;
        this.mongoDatabase = mongoDatabase;
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(
                MessageFormat.format("mongodb+srv://{0}:{1}@{2}/?retryWrites=true&w=majority", mongoUser, mongoPassword, mongoHost)
        );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), mongoDatabase);
    }

}
