package com.model;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCourier extends Courier {
    private static final String RANDOM_LOGIN = RandomStringUtils.random(10, true, false);
    private static final String RANDOM_PASS = RandomStringUtils.random(10, true, true);
    private static final String RANDOM_NAME = RandomStringUtils.random(10, true, false);

    public RandomCourier() {
        super(RANDOM_LOGIN, RANDOM_PASS, RANDOM_NAME);
    }
}
