package com.experis.test;

import com.experis.WaitableQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NProducersMConsumersTest {
    private final int numberOfProd = 10;
    private final int numberOfCons = 5;

    @Test
    void nProducersMConsumers() {

        var q = new WaitableQueue<Integer>(100);
        final var N = 100_000;
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfProd; i++) {
            threads.add(createProd(q, N, i, numberOfProd));
        }
        int[] arr = new int[N];

        for (int i = 0; i < numberOfCons; i++) {
            threads.add(createCons(q, N, arr, numberOfCons));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != 1) {
                fail();
            }

        }
        assertEquals(0,q.size());

    }

    private Thread createCons(WaitableQueue<Integer> q, int N, int[] arr, int numberOfCons) {

        var cons = new Thread(() -> {

            for (int i = 0; i < N; i += numberOfCons) {
                try {
                    var r = q.dequeue();
                    arr[r]++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return cons;
    }

    private Thread createProd(WaitableQueue<Integer> q, int N, int indexStart, int jump) {
        var prod = new Thread(() -> {

            for (int i = indexStart; i < N; i += jump) {
                try {
                    q.enqueue(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return prod;
    }


}