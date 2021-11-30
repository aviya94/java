package com.experis.tests;

import com.experis.AvgTask;
import com.experis.MaxTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AvgTaskTest {
    private int[] arr;
    private ExecutorService executor;
    private DoubleAdder avg;

    @BeforeEach
    void setUp() {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        arr = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        avg = new DoubleAdder();
    }

    @Test
    void run() throws InterruptedException {
        int rang = 1000;
        for (int i = 0; i < arr.length / rang; i++) {
            executor.submit(new AvgTask(arr, i * rang, (i + 1) * rang, avg));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        IntStream stream = IntStream.of(this.arr);
        double excepted = stream.average().getAsDouble();
        double res = avg.doubleValue();

        assertEquals(excepted, res);
    }
}