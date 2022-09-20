package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL2_ReverseLinkedList_Recursive {

    public static Node<Integer> reverse(Node<Integer> current, Node<Integer> prev) {

        // if initial list is null
        if (current == null)
            return current;

        // reached last
        if (current.next == null) {
            current.next = prev;
            return current;
        }

        Node<Integer> next = current.next;

        current.next = prev;
        prev = current;
        current = next;

        return reverse(current, prev);
    }


    public static void main(String[] args) {

        // 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // traverse
        traverse(head); // 1 2 3 4 5
        head = reverse(head, null);
        traverse(head); // 5 4 3 2 1
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
