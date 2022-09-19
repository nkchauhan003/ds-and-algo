package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL2_ReverseLinkedList_Iterative {

    public static Node<Integer> reverse(Node<Integer> head) {

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
