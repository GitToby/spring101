package com.tobydevlin.exmaples.spring101;

import com.tobydevlin.exmaples.spring101.pojo.Thinggy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thinggy2 extends Thinggy {
    Logger LOGGER = LoggerFactory.getLogger(Thinggy2.class);

    public Thinggy2(int value, String descriptor) {
        super(value, descriptor);
    }

    @Override
    public void run() {
        int totalRuns = 0;
        int totalRuntime = 0;
        long period = 1500L;
        while (true) {
            long start = System.currentTimeMillis();
            LOGGER.info("2: Doing {} | Total Time: {} \t| Expected Time: {}\t | Diff: {}", this.getDescriptor(), totalRuntime, totalRuns * period, totalRuntime - (totalRuns * period));
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
