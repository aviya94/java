package com.experis;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManageTasks {
    private PriorityQueue<Task> tasks = new PriorityQueue<>();
    private final Lock lock = new ReentrantLock();
    private Task popTask;

    public Task getPopTask() {
        lock.lock();
        try {
            return popTask;
        } finally {
            lock.unlock();
        }
    }

    public void setPopTask(Task popTask) {
        lock.lock();
        try {
            this.popTask = popTask;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            if (tasks.isEmpty()) {
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public Task peek() {
        lock.lock();
        try {
            return tasks.peek();
        } finally {
            lock.unlock();
        }
    }

    public void add(Task task) {
        lock.lock();
        try {
            tasks.add(task);
        } finally {
            lock.unlock();
        }
    }

    public void remove(Task task) {
        lock.lock();
        try {
            if(tasks.remove(task)==false);
            {
                if(popTask!=null) {
                    if (popTask.equals(task)) {
                        popTask = null;
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public Task poll() {
        lock.lock();
        try {
            var t = tasks.poll();
            popTask = t;
            return t;
        } finally {
            lock.unlock();
        }
    }
}
