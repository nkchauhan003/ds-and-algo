package com.cb.stack;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Stack using Queue
 * Time: O(N)
 * Space: O(N)
 * */
public class ST2_ImplementStackUsingSingleQueue {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int e) {
        q.add(e);

        // last becomes first
        for (int i = 0; i < q.size() - 1; i++)
            q.add(q.poll());

    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public int size() {
        return q.size();
    }
}

class ST2Impl {
    public static void main(String[] args) {
        ST2_ImplementStackUsingSingleQueue stack = new ST2_ImplementStackUsingSingleQueue();

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
