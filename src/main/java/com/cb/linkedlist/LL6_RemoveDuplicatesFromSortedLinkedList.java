package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL6_RemoveDuplicatesFromSortedLinkedList {

    public static void removeDuplicate(Node<Integer> head) {

        Node<Integer> prev = null;
        Node<Integer> current = head;
        while (current != null) {
            if (prev != null && prev.data == current.data)
                prev.next = current.next;
            else
                prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {

        // 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);

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
