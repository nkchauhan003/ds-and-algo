package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL3_DetectLoopInLinkedList_WithoutModifyNode {

    public static boolean containsLoop(Node<Integer> head) {

        if (head == null || head.next == null)
            return false;

        Node<Integer> current = head;
        Node<Integer> tmp = new Node<>(-1);

        while (current != null) {
            if (current.next == tmp)
                return true;
            Node<Integer> next = current.next;
            current.next = tmp;
            current = next;
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

        System.out.println("Contains Loop: " + containsLoop(head)); // true
    }

    static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
