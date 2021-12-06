package com.experis;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long timeNext;
    private final int periodicTime;
    private final TimeUnit timeUnit;

    public Timer(long timeNext, int periodicTime, TimeUnit timeUnit) {
        this.timeNext = timeNext;
        this.periodicTime = periodicTime;
        this.timeUnit = timeUnit;
    }

    public void sleep() {
        try {
            timeUnit.sleep(periodicTime);
        } catch (InterruptedException e) {
        }
    }

    public long getTimeNext() {
        return timeNext;
    }

    public void updateTimeNext() {
        timeNext = System.currentTimeMillis() + timeUnit.toMillis(periodicTime);
    }
}
