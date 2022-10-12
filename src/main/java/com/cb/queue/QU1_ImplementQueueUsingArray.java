package com.cb.queue;


import java.util.NoSuchElementException;

/*
 * Queue using array
 * Time: O(1)
 * Space: O(N)
 * */
public class QU1_ImplementQueueUsingArray {

    private int start, end, maxSize, currentSize;
    private int arr[];

    public QU1_ImplementQueueUsingArray(int maxSize) {
        this.arr = new int[maxSize];
        this.start = -1;
        this.end = -1;
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public void add(int e) {
        if (currentSize == maxSize) {
            System.out.println("Queue is full !!!");
            return;
        }

        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            // to use array circularly
            end = (end + 1) % maxSize;
        }
        arr[end] = e;
        currentSize++;
    }

    public int peek() {
        if (currentSize == 0)
            throw new NoSuchElementException();
        return arr[start];
    }

    public int poll() {
        if (currentSize == 0)
            throw new NoSuchElementException();
        int e = arr[start];

        // to use array circularly
        start = (start + 1) % maxSize;
        currentSize--;
        return e;
    }

    public int size() {
        return currentSize;
    }
}

class Impl {
    public static void main(String[] args) {
        QU1_ImplementQueueUsingArray q = new QU1_ImplementQueueUsingArray(6);
        q.add(4);
        q.add(14);
        q.add(24);
        q.add(34);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.size());
    }
}
