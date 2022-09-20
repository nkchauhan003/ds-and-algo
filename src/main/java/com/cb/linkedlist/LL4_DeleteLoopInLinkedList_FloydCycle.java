package com.cb.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class LL4_DeleteLoopInLinkedList_FloydCycle {

    public static Node commonPoint(Node<Integer> head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return fast;
        }
        return null;
    }

    public static void deleteCycle(Node<Integer> head) {

        if (head == null || head.next == null)
            return;

        Node fast = commonPoint(head);

        // no loop detected
        if (fast == null)
            return;

        Node slow = head;

        if (slow == fast) {
            while (fast.next != slow)
                fast = fast.next;
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        fast.next = null;
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

        deleteCycle(head);
        traverse(head);
    }

    public static void traverse(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
