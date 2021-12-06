package com.experis.tests;

import com.experis.PeriodicExecutor;
import com.experis.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

class PeriodicExecutorTest {
    private PeriodicExecutor periodicExecutor;

    @BeforeEach
    void setUp() throws InterruptedException {
        periodicExecutor = new PeriodicExecutor(10);
    }

    @Test
    void submit() {
        var firstTask = new TaskRunnable("* "+  LocalDateTime.now().toLocalTime());
        var secondTask = new TaskRunnable("= " + LocalDateTime.now().toLocalTime());
        var thirdTask = new TaskRunnable("& " + LocalDateTime.now().toLocalTime());

        try {
            periodicExecutor.submit(firstTask, 1, TimeUnit.SECONDS,5,TimeUnit.SECONDS);
            periodicExecutor.submit(secondTask, 2, TimeUnit.SECONDS);
            periodicExecutor.submit(thirdTask, 3, TimeUnit.SECONDS);
            periodicExecutor.remove(new Task(secondTask, 0, TimeUnit.SECONDS,0,TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(25000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         periodicExecutor.shutdown();

    }
}