package com.experis;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueTasksRunnable {
    private ManageTasks tasks;
    private AtomicBoolean stop;
    private Thread thread;
    private Lock lock;
    private Condition wakeUp;


    public QueueTasksRunnable(ManageTasks tasks, Condition wakeUp, Lock lock) {
        stop = new AtomicBoolean(false);
        this.tasks = tasks;
        this.lock = lock;
        this.wakeUp = wakeUp;
        thread = new Thread(() -> run());
        thread.start();

    }

    public void stopToRun() {
        stop.set(true);
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
    }

    private void run() {
        while (stop.get() == false) {
            try {
                while (!tasks.isEmpty()) {

                   var t=tasks.sleepUntilNext();
                    var time = t.getTimer().getTimeNext();

                    if (System.currentTimeMillis() >= time) {
                        runTask(t);
                        updateTaskTime(t);
                    }
                }

            } catch (InterruptedException e) {
            }
        }
    }


    private void runTask(Task t) {
        try {
            t.run();
        } catch (Exception e) {
            System.out.println("Exception in thread" + Thread.currentThread());
        }
    }

    private void updateTaskTime(Task t) {
        t.getTimer().updateTimeNext();
        if (tasks.getPopTask() != null) {
            tasks.add(t);
        }
    }

    private void sleepUntilNext(Task t) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(t.getTimer().getTimeNext() - System.currentTimeMillis());

    }

}
