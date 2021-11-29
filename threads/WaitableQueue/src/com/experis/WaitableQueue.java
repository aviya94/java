package com.experis;

import java.util.concurrent.Semaphore;

public class WaitableQueue<T> {
    private T[] data;
    private int tail;
    private int head;
    private int size;
    private final Object lock = new Object();
    Semaphore semaphoreEnqueue;
    Semaphore semaphoreDequeue;

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
        synchronized (lock) {
            ++size;
            data[tail++] = value;
            if (tail == capacity()) {
                tail = 0;
            }
        }
        semaphoreDequeue.release();
    }

    private int capacity() {
        return data.length;
    }


    public T dequeue() throws InterruptedException {
        semaphoreDequeue.acquire();
        synchronized (lock) {
            --size;
            var r = data[head++];
            if (head == capacity()) {
                head = 0;
            }
            semaphoreEnqueue.release();
            return r;
        }
    }

    public Boolean isEmpty() {
        synchronized (lock) {
            if (size == 0) {
                return true;
            }
            return false;
        }
    }

    public Boolean isFull() {
        synchronized (lock) {
            if (size == capacity()) {
                return true;
            }
            return false;
        }
    }

    public int size() {
        return size;
    }
}
