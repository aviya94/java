package com.experis;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManageTasks implements Runnable {
    private PriorityQueue<Task> tasks;
    private final Lock lock = new ReentrantLock();
    private ExecutorService executor;

    public ManageTasks(PriorityQueue<Task> tasks, ExecutorService executor) {
        this.tasks = tasks;
        this.executor = executor;
    }

    @Override
    public void run() {
        while (true) {

            while (!tasks.isEmpty()) {
                var t = tasks.peek();

                if (System.currentTimeMillis() >= t.getTimeNext() && t.isDone() == true) {
                    executor.submit(t);
                    updateTaskTime();

                } else {
                    pullFromQueueAndAdd();
                }
            }
        }
    }

    private void pullFromQueueAndAdd() {
        lock.lock();
        try {
            var t = tasks.poll();
            tasks.add(t);

        } finally {
            lock.unlock();
        }
    }

    private void updateTaskTime() {
        lock.lock();
        try {
            var t = tasks.peek();
            t.updateTimeNext();

        } finally {
            lock.unlock();
        }
    }
}
