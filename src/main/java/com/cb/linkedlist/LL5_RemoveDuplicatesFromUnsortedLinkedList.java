package com.cb.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class LL5_RemoveDuplicatesFromUnsortedLinkedList {

    public static void removeDuplicate(Node<Integer> head) {
        Set<Integer> set = new HashSet<Integer>();
        Node<Integer> prev = null;
        Node<Integer> current = head;
        while (current != null) {
            if (set.contains(current.data))
                prev.next = current.next;
            else
                prev = current;
            set.add(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        // 1->2->3->4->5
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // traverse
        traverse(head);
        removeDuplicate(head);
        traverse(head);
    }

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
