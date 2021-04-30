package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.components.data.RecipeRepository;
import com.tobydevlin.exmaples.spring101.pojo.Recipe;
import com.tobydevlin.exmaples.spring101.pojo.Thinggy;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootApplication
public class ServiceMain implements CommandLineRunner {
    private final RecipeRepository recipeRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ServiceMain.class);

    @Autowired
    public ServiceMain(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        Recipe myR = Recipe.builder().host("test 1234").build();
//        recipeRepository.insert(myR);
        LOGGER.info("Recipes found with findAll():");
        LOGGER.info("-------------------------------");
        for (Recipe customer : recipeRepository.findAll().parallelStream().limit(10).collect(Collectors.toCollection(ArrayList::new))) {
            LOGGER.info(String.valueOf(customer));
        }
        MutableList<Integer> work = Lists.mutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        work.parallelStream().forEach(val -> {
            LOGGER.info("Starting for value {}", val);
            Thinggy t;
            if (val % 2 > 0) {
                t = new Thinggy1(val, String.format("APPLES for value %s", val));
            } else {
                t = new Thinggy2(val, String.format("BANANA for value %s", val));
            }
            t.run();
        });

        LOGGER.info("Done construction");

//        // loop
//        LOGGER.info("Loop");
//        long start = System.currentTimeMillis();
//        int total = 0;
//        for (int val : work) {
//            total += doWork(String.format("Work for %s", val), val);
//        }
//        long timeTaken = System.currentTimeMillis() - start;
//        LOGGER.info("Total: " + total);
//        LOGGER.info("Total time: " + timeTaken + "ms");
//
//        // stream
//        LOGGER.info("Stream");
//        long start1 = System.currentTimeMillis();
//        AtomicInteger total1 = new AtomicInteger();
//        work.forEach(val -> {
//            try {
//                total1.addAndGet(doWork(String.format("Work for %s", val), val));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        long timeTaken1 = System.currentTimeMillis() - start1;
//        LOGGER.info("Total: " + total1);
//        LOGGER.info("Total time: " + timeTaken1 + "ms");
//
//        // parallel stream
//        LOGGER.info("Parallel Stream");
//        long start2 = System.currentTimeMillis();
//        AtomicInteger total2 = new AtomicInteger();
//        work.parallelStream().forEach(val -> {
//            try {
//                total2.addAndGet(doWork(String.format("Work for %s", val), val));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        long timeTaken2 = System.currentTimeMillis() - start2;
//        LOGGER.info("Total: " + total2);
//        LOGGER.info("Total time: " + timeTaken2 + "ms");
    }

    private int doWork(String tag, int val) throws InterruptedException {
        int total = 100 * val;
        LOGGER.info("Doing {} | {}", tag, total);
        Thread.sleep(total);
        return total;
    }

    private void ongoingWork1(String tag, int val) throws InterruptedException {

    }

    private void ongoingWork2(String tag, int val) throws InterruptedException {
        int total = 0;
        while (true) {
            LOGGER.info("1: Doing {} | {}", tag, total);
            total += 1;
            Thread.sleep(100L * val);
        }
    }
}
