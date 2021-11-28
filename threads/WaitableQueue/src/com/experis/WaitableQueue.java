package com.experis;

public class WaitableQueue<T> {
    private T[] data;
    private int capacity;
    private int next;
    private final Object lock = new Object();

    public WaitableQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        next = 0;
    }

    public void enqueue(T value) throws InterruptedException {
        synchronized (lock) {
            // if data exist
            //  wait til its taken
            while (isFull()) {
                lock.wait();
            }
            
            assert !isFull();
            data[next++] = value;

        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (lock) {
            // if not available
            //  wait till available

            while (isEmpty()) {
                lock.wait();
            }
            assert !isEmpty();
            var r = data[--next];

            return r;
        }
    }

    public Boolean isEmpty() {
        synchronized (lock) {
            if (next == 0) {
                return true;
            }
            return false;
        }
    }

    public Boolean isFull() {
        synchronized (lock) {
            if (capacity == next) {
                return true;
            }
            return false;
        }
    }

    public int size(){
        return next;
    }
}
