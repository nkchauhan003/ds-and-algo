package com.cb.linkedlist;

/*
 * Time Complexity: O(max(n,m))
 * Space Complexity: O(1)
 * */
public class LL8_AddTwoNumbersRepresentedByLinkedList {

    public static Node sum(Node<Integer> number1, Node<Integer> number2) {

        number1 = reverse(number1);
        number2 = reverse(number2);

        Node sumListRoot = null;
        Node sumListCurrent = null;

        int carrying = 0;
        while (number1 != null || number2 != null || carrying > 0) {

            int currentNodeSum = carrying;

            if (number1 != null) {
                currentNodeSum += number1.data;
                number1 = number1.next;
            }
            if (number2 != null) {
                currentNodeSum += number2.data;
                number2 = number2.next;
            }

            carrying = currentNodeSum / 10;
            currentNodeSum = currentNodeSum % 10;

            // Adding sum to new Linked List
            if (sumListCurrent == null) {
                sumListCurrent = new Node(currentNodeSum);
                sumListRoot = sumListCurrent;
            } else {
                sumListCurrent.next = new Node(currentNodeSum);
                sumListCurrent = sumListCurrent.next;
            }
        }
        return reverse(sumListRoot);
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

        // 9->2->7
        Node number1 = new Node(9);
        number1.next = new Node(2);
        number1.next.next = new Node(7);

        // 9->3
        Node number2 = new Node(9);
        number2.next = new Node(3);

        // traverse
        traverse(number1); // 927
        traverse(number2); // 93
        Node sum = sum(number1, number2);
        traverse(sum); // 1020
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
