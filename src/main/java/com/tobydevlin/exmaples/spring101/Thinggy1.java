package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.pojo.Thinggy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thinggy1 extends Thinggy {
    Logger LOGGER = LoggerFactory.getLogger(Thinggy1.class);

    public Thinggy1(int value, String descriptor) {
        super(value, descriptor);
    }

    @Override
    public void run() {
        int totalRuns = 0;
        int totalRuntime = 0;
        long period = 1000L;
        while (true) {
            long start = System.currentTimeMillis();
            LOGGER.info("1: Doing {} | Total Time: {} \t| Expected Time: {}\t | Diff: {}", this.getDescriptor(), totalRuntime, totalRuns * period, totalRuntime - (totalRuns * period));
            totalRuns += 1;
            try {
                Thread.sleep(period * getValue());
            } catch (InterruptedException e) {
                LOGGER.error("Error in sleep", e);
            }
            totalRuntime += System.currentTimeMillis() - start;
        }
    }
}
