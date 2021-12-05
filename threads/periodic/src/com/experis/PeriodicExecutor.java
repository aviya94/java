package com.experis;

import java.util.*;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PeriodicExecutor {
    private final Thread taskRunnerThread;
    private ManageTasks manageTasks;
    private ExecutorService executor;
    private QueueTasksRunnable queueTasksRunnable;

    public PeriodicExecutor(int thresholdThreads) throws InterruptedException {
        executor = Executors.newFixedThreadPool(thresholdThreads);
        manageTasks = new ManageTasks();
        queueTasksRunnable=new QueueTasksRunnable(manageTasks);
        taskRunnerThread = new Thread(queueTasksRunnable);
        taskRunnerThread.start();
    }

    public void submit(Runnable task, int periodicTime, TimeUnit timeUnit) throws InterruptedException {
            manageTasks.add(new Task(task, periodicTime, timeUnit));
    }

    public void submit(Runnable task, int periodicTime, TimeUnit periodicTimeUnit, int delayTime, TimeUnit
            delayTimeUnit) throws InterruptedException {

        delayTimeUnit.sleep(delayTime);
        submit(task, periodicTime, periodicTimeUnit);
    }

    public void remove(Task task) {
            manageTasks.remove(task);
    }

    public void shutdown() {
        try {
            taskRunnerThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
