package com.experis.tests;

import com.experis.PeriodicExecutor;
import com.experis.Task;
import com.experis.TaskRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicExecutorTest {
    private PeriodicExecutor periodicExecutor;

    @BeforeEach
    void setUp() throws InterruptedException {
        periodicExecutor = new PeriodicExecutor(10);
    }

    @Test
    void submit() {
        var firstTask = new TaskRunnable("*");
        var secondTask = new TaskRunnable("=");
        var thirdTask = new TaskRunnable("&");

        try {
            periodicExecutor.submit(firstTask, 1, TimeUnit.SECONDS);
            periodicExecutor.submit(secondTask, 5, TimeUnit.SECONDS);
            periodicExecutor.submit(thirdTask, 3, TimeUnit.SECONDS);
            periodicExecutor.remove(new Task(secondTask, 0, TimeUnit.SECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        periodicExecutor.shutdown();

    }
}