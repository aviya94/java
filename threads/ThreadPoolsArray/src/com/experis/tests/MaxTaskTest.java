package com.experis.tests;

import com.experis.MaxTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxTaskTest {
    private MaxTask maxTask;
    private int[] arr;
    private ExecutorService executor;
    AtomicInteger max;

    @BeforeEach
    void setUp() {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        arr = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        max = new AtomicInteger(arr[0]);

    }

    @Test
    void run() throws InterruptedException {
        int rang = 1000;
        for (int i = 0; i < arr.length / rang; i++) {
            executor.submit(new MaxTask(arr, i * rang, (i + 1) * rang, max));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        IntStream stream = IntStream.of(this.arr);
        int excepted = stream.parallel()
                .max().getAsInt();
        assertEquals(excepted, max.get());
    }
}