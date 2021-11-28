package com.experis.test;

import com.experis.WaitableQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WaitableQueueTest {
    private WaitableQueue<Integer> waitableQueue;
    int size = 12;

    @BeforeEach
    void setUp() {
        waitableQueue = new WaitableQueue<Integer>(size);

    }

    @Test
    void enqueue_dequeue() {
        var prod = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                try {
                    waitableQueue.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        int[] result = new int[size];
        var cons = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                try {
                    var r = waitableQueue.dequeue();
                    result[i] = r;
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
        for (int i = 0; i < result.length; i++) {
            assertTrue(isContain(result, i, 1));
        }


    }

    private Boolean isContain(int[] result, int index, int count) {
        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == index) {
                counter++;
            }
        }
        if (counter == count) {
            return true;
        }
        return false;
    }

    @Test
    void twoProducersOneConsumer() {
        var prod = new Thread(() -> {
            for (int i = 0; i < size / 2; i++) {
                try {
                    waitableQueue.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        var prod2 = new Thread(() -> {
            for (int i = size / 2; i < size; i++) {
                try {
                    waitableQueue.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        int[] result = new int[size];
        var cons = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                try {
                    var r = waitableQueue.dequeue();
                    result[i] = r;
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
            cons.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.length; i++) {
            assertTrue(isContain(result, i, 1));
        }

    }

    @Test
    void oneProducersTwoConsumers() {

        var prod = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                try {

                    waitableQueue.enqueue(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        int[] result = new int[size];
        var cons = new Thread(() -> {
            for (int i = 0; i < size / 2; i++) {
                try {
                    var r = waitableQueue.dequeue();
                    result[i] = r;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var cons2 = new Thread(() -> {
            for (int i = size / 2; i < size; i++) {
                try {
                    var r = waitableQueue.dequeue();
                    result[i] = r;
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.length; i++) {
            assertTrue(isContain(result, i, 1));
        }


    }

    @Test
    void sixProducersTwoConsumers() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < size / 6; j++) {
                    try {
                        waitableQueue.enqueue(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        int[] result = new int[size];
        var cons = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                try {
                    var r = waitableQueue.dequeue();
                    result[i] = r;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Thread t : threads) {
            t.start();
        }
        cons.start();

        try {
            for (Thread t : threads) {
                t.join();
            }
            cons.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.length / 6; i++) {
            assertTrue(isContain(result, i, 6));
        }


    }

    @Test
    void nProducersMConsumers() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < size / 6; j++) {
                    try {
                        waitableQueue.enqueue(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        int[] result = new int[size];
        for (int j = 0; j < 3; j++) {
            threads.add(new Thread(() -> {
                for (int i = 0; i < size / 3; i++) {
                    try {
                        var r = waitableQueue.dequeue();
                        result[i] = r;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.length / 6; i++) {
            assertTrue(isContain(result, i, 6));
        }


    }
}