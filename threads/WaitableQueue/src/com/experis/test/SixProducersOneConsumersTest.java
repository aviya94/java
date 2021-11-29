package com.experis.test;

import com.experis.WaitableQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SixProducersOneConsumersTest {

    @Test
    void sixProducersOneConsumers() {
        var q = new WaitableQueue<Integer>(100);
        final var N = 100_000;
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            threads.add(createProd(q, N, i, 6));
        }

        int[] arr = new int[N];

        var cons = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                try {
                    var r = q.dequeue();
                    arr[r]++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Thread t : threads) {
            t.start();
        }

        cons.start();

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                fail();

            }
        }
        assertEquals(0,q.size());
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