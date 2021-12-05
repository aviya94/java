package com.experis;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PeriodicExecutor {
    private ManageTasks manageTasks;
    private ExecutorService executor;
    private QueueTasksRunnable queueTasksRunnable;
    private final Lock lock = new ReentrantLock();
    private Condition wakeUp = lock.newCondition();

    public PeriodicExecutor(int thresholdThreads) throws InterruptedException {
        executor = Executors.newFixedThreadPool(thresholdThreads);
        manageTasks = new ManageTasks();
        queueTasksRunnable = new QueueTasksRunnable(manageTasks, wakeUp, lock);
    }

    public void submit(Runnable task, int periodicTime, TimeUnit timeUnit) throws InterruptedException {
        submit(task, periodicTime, timeUnit, 0, TimeUnit.MILLISECONDS);
    }

    public void submit(Runnable task, int periodicTime, TimeUnit periodicTimeUnit, int delayTime, TimeUnit
            delayTimeUnit) throws InterruptedException {
        Task t = new Task(task, periodicTime, periodicTimeUnit, delayTime, delayTimeUnit);
        manageTasks.add(t);

        if (manageTasks.peek().equals(t)) {
            //  wakeUp.signal();
            // queueTasksRunnable.getThread().interrupt();
        }

    }

    public void remove(Task task) {

            manageTasks.remove(task);
    }

    public void shutdown() {
        queueTasksRunnable.stopToRun();
    }
}
