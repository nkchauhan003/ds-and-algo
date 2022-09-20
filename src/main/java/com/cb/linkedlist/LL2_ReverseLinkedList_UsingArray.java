package com.cb.linkedlist;

/*
 * Time Complexity: O(3n) or O(n)
 * Space Complexity: O(n)
 * */
public class LL2_ReverseLinkedList_UsingArray {

    public static Node<Integer> reverse(Node<Integer> head) {

        if (head == null)
            return null;


        /* Get length of the linkedList start */
        int n = 0;
        Node current = head;
        while (current != null) {
            n = n + 1;
            current = current.next;
        }
        /* Get length of the linkedList end */

        // initialize array
        Node[] arr = new Node[n];

        /* Fill array with linkedList nodes start */
        current = head;
        for (int i = 0; i < n; i++) {
            arr[i] = current;
            current = current.next;
        }
        /* Fill array with linkedList nodes end */

        // point new head to last element
        Node newHead = arr[n - 1];
        Node<Integer> movingPointer = newHead;

        // from second last element
        for (int i = n - 2; i >= 0; i--) {
            movingPointer.next = arr[i];
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
        head = reverse(head);
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
