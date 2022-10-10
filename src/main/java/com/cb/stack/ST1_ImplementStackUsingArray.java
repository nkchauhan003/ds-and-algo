package com.cb.stack;

import java.util.NoSuchElementException;

/*
 * Stack using array
 * Time: O(N)
 * Space: O(N)
 * */
public class ST1_ImplementStackUsingArray {
    private int[] arr;
    private int top;

    private int size;

    public ST1_ImplementStackUsingArray(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.size = size;
    }

    public void push(int e) {
        if (top >= size - 1)
            throw new StackOverflowError();
        arr[++top] = e;
    }

    public int pop() {
        if (top == -1)
            throw new NoSuchElementException();
        return arr[top--];
    }

    public int top() {
        if (top == -1)
            throw new NoSuchElementException();
        return arr[top];
    }

    public int size() {
        return top + 1;
    }
}

class Impl {
    public static void main(String[] args) {
        ST1_ImplementStackUsingArray stack = new ST1_ImplementStackUsingArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.size());

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);
        stack.push(5);
    }
}
