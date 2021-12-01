package com.experis.tests;

import com.experis.PeriodicExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicExecutorTest {
    PeriodicExecutor periodicExecutor;

    @BeforeEach
    void setUp() throws InterruptedException {
        periodicExecutor = new PeriodicExecutor(10);
    }

    @Test
    void submit() {

        periodicExecutor.submit(() -> System.out.println("*"), 1, TimeUnit.SECONDS);
        periodicExecutor.submit(() -> System.out.println("="), 5, TimeUnit.SECONDS);
        //  periodicExecutor.submit(()->System.out.println("&"),3, TimeUnit.SECONDS);
        periodicExecutor.exit();

    }
}