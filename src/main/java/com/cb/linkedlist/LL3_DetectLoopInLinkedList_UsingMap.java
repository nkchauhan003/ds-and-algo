package com.cb.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class LL3_DetectLoopInLinkedList_UsingMap {

    public static boolean containsLoop(Node<Integer> head) {

        if (head == null)
            return false;

        Set<Node<Integer>> set = new HashSet<>();
        Node<Integer> current = head;

        while (current != null) {
            if (set.contains(current))
                return true;
            set.add(current);
            current = current.next;
        }
        return false;
    }


    public static void main(String[] args) {

        var head = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);

        // 1->2->3->4->5->2...
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2; // making loop

        System.out.println("Contains Loop: " + containsLoop(head));
    }

    static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
