package com.cb.linkedlist;

import java.util.Stack;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class LL2_ReverseLinkedList_UsingStack {

    public static Node<Integer> reverse(Node<Integer> head, Stack<Node<Integer>> stack) {

        if (head == null)
            return null;

        /* Fill stack with linkedList nodes start */
        Node<Integer> current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        /* Fill stack with linkedList nodes end */

        // point new head to top
        Node<Integer> newHead = stack.pop();
        Node<Integer> movingPointer = newHead;

        /* Popping LIFO */
        while (!stack.isEmpty()) {
            movingPointer.next = stack.pop();
            movingPointer = movingPointer.next;
        }

        // previous head (now last element) should point to null
        movingPointer.next = null;

        return newHead;
    }


    public static void main(String[] args) {

        // 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // traverse
        traverse(head);
        head = reverse(head, new Stack<Node<Integer>>());
        traverse(head);
    }

    // helper fn to traverse
    public static void traverse(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
