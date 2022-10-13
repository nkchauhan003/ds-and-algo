package com.cb.queue;


import java.util.Stack;

/*
 * Queue using Stack
 * Time: Amortized O(1)
 * Space: O(N)
 * */
public class QU2_ImplementQueueUsingStack {

    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    public void add(int e) {
        input.push(e);
    }

    // O(n) or O(1)
    public int peek() {
        while (!input.empty())
            output.push(input.pop());
        return output.peek();

    }

    // O(n) or O(1)
    public int poll() {
        while (!input.empty())
            output.push(input.pop());
        return output.pop();
    }

    public int size() {
        return input.size() + output.size();
    }
}

class QU2Impl {
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
