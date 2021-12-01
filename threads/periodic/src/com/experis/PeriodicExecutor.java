package com.experis;

import java.util.*;

import java.util.concurrent.*;


public class PeriodicExecutor {
    private ArrayDeque<Task> tasks;
    private final Thread taskRunnerThread;
    private ManageTasks manageTasks;
   private ExecutorService executor;

    public PeriodicExecutor(int threadsAmount) throws InterruptedException {
        executor= Executors.newFixedThreadPool(threadsAmount);
        tasks = new ArrayDeque<>();
        manageTasks = new ManageTasks(tasks,executor);
        taskRunnerThread = new Thread(manageTasks);
        taskRunnerThread.start();
    }

    public void submit(Runnable task, int periodicTime, TimeUnit timeUnit) {
        tasks.addLast(new Task(task, periodicTime, timeUnit));
    }

    public void submit(Runnable task, int periodicTime, TimeUnit periodicTimeUnit, int delayTime, TimeUnit
            delayTimeUnit) throws InterruptedException {
        delayTimeUnit.sleep(delayTime);
        submit(task, periodicTime, periodicTimeUnit);
    }

    public void exit() {
        try {
            taskRunnerThread.join();
            executor.shutdown();
            executor.awaitTermination(20,TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
