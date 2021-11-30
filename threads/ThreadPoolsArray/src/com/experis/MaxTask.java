package com.experis;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxTask implements Runnable {
    private final int[] data;
    private final int start;
    private final int end;
    private AtomicInteger max;

    public MaxTask(int[] data, int start, int end, AtomicInteger max) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (max.get() < data[i]) {
                max.set(data[i]);
            }
        }

    }
}
