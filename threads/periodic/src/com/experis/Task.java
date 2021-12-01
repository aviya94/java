package com.experis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public record Task(Runnable task, int periodicTime, TimeUnit timeUnit)implements Runnable{

public void sleep(){
    try {
        timeUnit().sleep(periodicTime());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    @Override
    public void run() {
    while (true) {
        sleep();
        task.run();
    }
    }
}
