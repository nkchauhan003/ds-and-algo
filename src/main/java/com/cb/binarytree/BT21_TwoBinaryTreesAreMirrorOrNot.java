package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n)
 * Space: O(h) for call stack
 * */
public class BT21_TwoBinaryTreesAreMirrorOrNot {
    private static boolean mirror(Node<Integer> t1, Node<Integer> t2) {

        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        return t1.data == t2.data && mirror(t1.left, t2.right) && mirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        System.out.println(mirror(t1(), t2()));
    }

    private static Node<Integer> t1() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        return root;
    }

    private static Node<Integer> t2() {
        Node<Integer> root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        return root;
    }

    // tree-node
    static class Node<T> {
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
