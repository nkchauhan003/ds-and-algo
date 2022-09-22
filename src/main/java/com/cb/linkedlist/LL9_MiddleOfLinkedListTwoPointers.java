package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL9_MiddleOfLinkedListTwoPointers {

    public static Node middle(Node<Integer> root) {
        if (root == null)
            return null;

        Node slow = root;
        Node fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        // 1->2->3->4->5->6->null
        Node evenNodes = new Node(1);
        evenNodes.next = new Node(2);
        evenNodes.next.next = new Node(3);
        evenNodes.next.next.next = new Node(4);
        evenNodes.next.next.next.next = new Node(5);
        evenNodes.next.next.next.next.next = new Node(6);

        // 1->2->3->4->5->null
        Node oddNodes = new Node(1);
        oddNodes.next = new Node(2);
        oddNodes.next.next = new Node(3);
        oddNodes.next.next.next = new Node(4);
        oddNodes.next.next.next.next = new Node(5);

        // traverse
        traverse(evenNodes);
        System.out.println(middle(evenNodes).data); //4

        traverse(oddNodes);
        System.out.println(middle(oddNodes).data); //3
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
