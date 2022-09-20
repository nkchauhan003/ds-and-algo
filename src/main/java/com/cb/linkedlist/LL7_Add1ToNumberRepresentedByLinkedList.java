package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL7_Add1ToNumberRepresentedByLinkedList {

    public static Node addOne(Node<Integer> head) {
        if (head == null)
            return null;

        head = reverse(head);

        Node<Integer> current = head;
        while (current.next != null && current.data >= 9) {
            current.data = 0;
            current = current.next;
        }
        current.data = current.data + 1;

        head = reverse(head);
        return head;
    }

    // utility function
    public static Node<Integer> reverse(
            Node<Integer> head) {

        Node<Integer> current = head;
        Node<Integer> prev = null;
        Node<Integer> next = null;

        while (current != null) {

            // keep next node safe
            next = current.next;

            // point current backwards
            current.next = prev;

            // for next loop 'current' will become 'prev'
            prev = current;

            // for next loop 'next' will become 'current'
            current = next;
        }

        head = prev;
        return head;
    }

    public static void main(String[] args) {

        // 1->2->3
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        // traverse
        traverse(head); // 999
        addOne(head);
        traverse(head); // 1000
    }

    public static void traverse(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data);
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
