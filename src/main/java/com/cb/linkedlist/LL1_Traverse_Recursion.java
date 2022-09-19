package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL1_Traverse_Recursion {

    public static void traverse(Node<Integer> head) {
        if (head == null)
            return;

        System.out.print(head.data+" ");
        traverse(head.next);
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
    }

    static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
