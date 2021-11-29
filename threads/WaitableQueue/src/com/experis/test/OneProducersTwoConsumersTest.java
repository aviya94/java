package com.experis.test;

import com.experis.WaitableQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneProducersTwoConsumersTest {

    @Test
    void oneProducersTwoConsumers() {
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

        int[] arr = new int[N];
        var cons = new Thread(() -> {
            for (int i = 0; i < N; i += 2) {
                try {
                    var r = q.dequeue();
                    arr[r]++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var cons2 = new Thread(() -> {
            for (int i = 1; i < N; i += 2) {
                try {
                    var r = q.dequeue();
                    arr[r]++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        prod.start();
        cons.start();
        cons2.start();

        try {
            prod.join();
            cons.join();
            cons2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != 1) {
                fail();
            }
        }
        assertEquals(0,q.size());
    }

}