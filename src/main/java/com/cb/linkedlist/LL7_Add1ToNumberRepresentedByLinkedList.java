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

        int sum = 0;
        int carry = 1;

        Node<Integer> current = head;
        Node prev = null;

        while (current != null && carry > 0) {
            sum = current.data + carry;

            current.data = sum % 10;
            carry = sum / 10;

            prev = current;
            current = current.next;
        }
        if (carry > 0)
            prev.next = new Node(carry);

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

        // 9->9->9->null
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        // traverse
        traverse(head); // 999
        head = addOne(head);
        traverse(head); // 1000

        // 9->9->9->null
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // traverse
        traverse(head); // 123
        head = addOne(head);
        traverse(head); // 124
    }

    public static void traverse(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");
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
