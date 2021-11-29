package com.experis.test;

import com.experis.WaitableQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoProducersOneConsumerTest {

    @Test
    void twoProducersOneConsumer() {
        var q = new WaitableQueue<Integer>(100);
        final var N = 100_000;

        var prod = new Thread(() -> {
            for (int i = 1; i < N; i += 2) {
                try {
                    q.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var prod2 = new Thread(() -> {
            for (int i = 0; i < N; i += 2) {
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
            int odd = 1;
            int even = 0;

            for (int i = 0; i < N; i++) {
                try {
                    var r = q.dequeue();
                    if (r % 2 == 0) {
                        if (r != even) {
                            flag[0] = false;
                        } else {
                            even += 2;
                        }
                    } else {
                        if (r != odd) {
                            flag[0] = false;
                        } else {
                            odd += 2;
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        prod.start();
        prod2.start();
        cons.start();

        try {
            prod.join();
            prod2.join();
            cons.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(flag[0]);
        assertEquals(0,q.size());

    }


}