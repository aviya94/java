package com.experis;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AvgTask implements Runnable {
    private final int[] data;
    private final int start;
    private final int end;
    private DoubleAdder avg;
    private Lock lock = new ReentrantLock();

    public AvgTask(int[] data, int start, int end, DoubleAdder avg) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.avg = avg;
    }

    @Override
    public void run() {
        Double sum = 0.0;

        for (int i = start; i < end; i++) {
            sum += data[i];
        }

        avg.add(sum / data.length);
    }
}
