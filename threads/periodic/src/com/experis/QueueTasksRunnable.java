package com.experis;

import java.util.concurrent.TimeUnit;

public class QueueTasksRunnable implements Runnable {
    private ManageTasks tasks;

    public QueueTasksRunnable(ManageTasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {

            while (!tasks.isEmpty()) {
                sleepUntilNext();
                var t = tasks.peek();

                if (System.currentTimeMillis() >= t.getTimeNext())
                    runTask(t);
                updateTaskTime();
            }
        }
    }

    private void runTask(Task t) {
        try {
            t.run();
        } catch (Exception e) {
            System.out.println("Exception int thread" + Thread.currentThread());
        }
    }

    private void updateTaskTime() {
        var t = tasks.poll();
        t.updateTimeNext();
        tasks.add(t);
    }

    public void sleepUntilNext() {
        var t = tasks.peek();

        try {
            TimeUnit.MILLISECONDS.sleep(t.getTimeNext() - System.currentTimeMillis());
        } catch (InterruptedException e) {
        }
    }

}
