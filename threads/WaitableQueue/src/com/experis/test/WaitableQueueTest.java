package com.experis.test;

import com.experis.WaitableQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WaitableQueueTest {
    private WaitableQueue<Integer> waitableQueue;

    @Test
    void enqueue_dequeue() {
        var q = new WaitableQueue<Integer>(100);
        final var N = 100_000;
        var prod = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                try {
                    q.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var flag = new boolean[1];
        flag[0] = true;
        var cons = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                try {
                    var r = q.dequeue();
                    if (i != r) {
                        flag[0] = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        prod.start();
        cons.start();

        try {
            prod.join();
            cons.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(flag[0]);

    }

}