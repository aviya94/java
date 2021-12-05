package com.experis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueTasksRunnable {
    private ManageTasks tasks;
    private AtomicBoolean stop;
    private Thread thread;
    private Lock lock = new ReentrantLock();

    public Thread getThread() {
        return thread;
    }

    public QueueTasksRunnable(ManageTasks tasks) {
        stop = new AtomicBoolean(false);
        this.tasks = tasks;
        thread = new Thread(() -> run());
        thread.start();
    }

    public void stopToRun() {
        stop.set(true);
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void run() {
        while (stop.get() == false) {
            try {
                lock.lock();

                while (!tasks.isEmpty()) {
                    var t = tasks.peek();
                    sleepUntilNext(t);

                    if (System.currentTimeMillis() >= t.getTimer().getTimeNext()) {
                        runTask(t);
                        updateTaskTime(t);
                    }
                }
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
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
        tasks.remove(t);
        t.getTimer().updateTimeNext();
        tasks.add(t);
    }

    private void sleepUntilNext(Task t) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(t.getTimer().getTimeNext() - System.currentTimeMillis());

    }

}
