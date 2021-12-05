package com.experis;

import java.sql.Time;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable, Comparable<Task> {
    private final Runnable task;
    private Timer timer;

    public Timer getTimer() {
        return timer;
    }

    public Task(Runnable task, int periodicTime, TimeUnit timeUnit, int delayTime, TimeUnit
            delayTimeUnit) {
        this.task = task;
        var timeNext = System.currentTimeMillis() +
                timeUnit.toMillis(periodicTime) + delayTimeUnit.toMillis(delayTime);
        timer = new Timer(timeNext, periodicTime, timeUnit);
    }

    @Override
    public void run() {
        timer.sleep();
        task.run();
    }

    @Override
    public int compareTo(Task t) {
        return (int) (timer.getTimeNext() - t.timer.getTimeNext());
    }

    public Runnable getTask() {
        return task;
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
}
