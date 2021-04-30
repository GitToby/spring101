package com.tobydevlin.exmaples.spring101.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Thinggy implements Runnable {
    private final int value;
    private final String descriptor;
}
