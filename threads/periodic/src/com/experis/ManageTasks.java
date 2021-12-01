package com.experis;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManageTasks implements Runnable {
    private ArrayDeque<Task> tasks;
    private final Lock lock = new ReentrantLock();
    private ExecutorService executor;
    private ArrayList<Task> runners;

    public ManageTasks(ArrayDeque<Task> tasks, ExecutorService executor) {
        runners = new ArrayList<>();
        this.tasks = tasks;
        this.executor = executor;
    }

    @Override
    public void run() {

        while (true) {

            while (!tasks.isEmpty()) {
                var t = tasks.peek();
                executor.submit(t);
                pullFromQueue();
            }
        }
    }

    private void pullFromQueue() {
        lock.lock();
        try {
            runners.add(tasks.poll());
        } finally {
            lock.unlock();
        }
    }
}
