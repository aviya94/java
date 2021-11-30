package com.experis;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitableQueue<T> {
    private T[] data;
    private int tail;
    private int head;
    private int size;
    private final Lock lock = new ReentrantLock();
    private Semaphore semaphoreEnqueue;
    private Semaphore semaphoreDequeue;

    public WaitableQueue(int capacity) {
        data = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
        semaphoreEnqueue = new Semaphore(capacity);
        semaphoreDequeue = new Semaphore(0);
    }

    public void enqueue(T value) throws InterruptedException {
        semaphoreEnqueue.acquire();

        lock.lock();
        ++size;
        data[tail++] = value;

        if (tail == capacity()) {
            tail = 0;
        }
        lock.unlock();

        semaphoreDequeue.release();
    }

    private int capacity() {
        return data.length;
    }


    public T dequeue() throws InterruptedException {
        semaphoreDequeue.acquire();

        lock.lock();
        try {
            --size;
            var r = data[head++];

            if (head == capacity()) {
                head = 0;
            }
            semaphoreEnqueue.release();
            return r;

        } finally {
            lock.unlock();
        }

    }

    public Boolean isEmpty() {
        lock.lock();

        try {
            if (size == 0) {
                return true;
            }
            return false;

        } finally {
            lock.unlock();
        }

    }

    public Boolean isFull() {
        lock.lock();

        try {
            if (size == capacity()) {
                return true;
            }
            return false;

        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return size;
    }
}
