package com.experis;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManageTasks {
    private PriorityQueue<Task> tasks = new PriorityQueue<>();
    private final Lock lock = new ReentrantLock();

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
            tasks.remove(task);
        } finally {
            lock.unlock();
        }
    }

    public Task poll() {
        lock.lock();
        try {
            return tasks.poll();
        } finally {
            lock.unlock();
        }
    }
}
