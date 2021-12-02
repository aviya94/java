package com.experis;

import java.util.*;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PeriodicExecutor {
    private PriorityQueue<Task> tasks;
    private final Thread taskRunnerThread;
    private ManageTasks manageTasks;
    private ExecutorService executor;
    private int thresholdThreads;
    private int threadsAmount = 0;

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();

    public PeriodicExecutor(int thresholdThreads) throws InterruptedException {
        executor = Executors.newFixedThreadPool(thresholdThreads);
        tasks = new PriorityQueue<>();
        manageTasks = new ManageTasks(tasks, executor);
        taskRunnerThread = new Thread(manageTasks);
        taskRunnerThread.start();
        this.thresholdThreads = thresholdThreads;
    }

    public void submit(Runnable task, int periodicTime, TimeUnit timeUnit) throws InterruptedException {
        lock.lock();
        try {

            while (threadsAmount == thresholdThreads) {
                notFull.await();
            }
            tasks.add(new Task(task, periodicTime, timeUnit));

        } finally {
            lock.unlock();
        }

    }

    public void submit(Runnable task, int periodicTime, TimeUnit periodicTimeUnit, int delayTime, TimeUnit
            delayTimeUnit) throws InterruptedException {

        delayTimeUnit.sleep(delayTime);
        submit(task, periodicTime, periodicTimeUnit);
    }

    public void remove(Task task) {
        lock.lock();
        try {
            tasks.remove(task);

        } finally {
            lock.unlock();
        }
    }

    public void exit() {
        try {
            taskRunnerThread.join();
            executor.shutdown();
            executor.awaitTermination(20, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
