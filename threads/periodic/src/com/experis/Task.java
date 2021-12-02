package com.experis;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Task implements Runnable, Comparable<Task> {
    private long timeNext;
    private final Runnable task;
    private final int periodicTime;
    private final TimeUnit timeUnit;
    private Boolean isDone = true;
    Lock lock = new ReentrantLock();

    public Task(Runnable task, int periodicTime, TimeUnit timeUnit) {
        this.task = task;
        this.periodicTime = periodicTime;
        this.timeUnit = timeUnit;
        this.timeNext = System.currentTimeMillis() + timeUnit.toMillis(periodicTime);
    }

    public void sleep() {
        try {
            timeUnit.sleep(periodicTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        updateIsDone(false);
        sleep();
        task.run();
        updateIsDone(true);
    }

    private void updateIsDone(Boolean isDone) {
        lock.lock();
        try {
            this.isDone = isDone;
        } finally {
            lock.unlock();
        }
    }

    public void updateTimeNext() {
        timeNext = System.currentTimeMillis() + timeUnit.toMillis(periodicTime);
    }

    @Override
    public int compareTo(Task t) {
        return (int) (timeNext - t.timeNext);
    }

    public Runnable getTask() {
        return task;
    }

    public Boolean isDone() {
        return isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return Objects.equals(task, task1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    public long getTimeNext() {
        return timeNext;
    }
}
