package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for call stack
 * */
public class BT3_DiameterOfBinaryTree_1 {

    // returns diameter or width
    private static int diameter(Node<Integer> root) {
        if (root == null)
            return 0;

        Diameter diameter = new Diameter();

        //  the goal is to update 'diameter' in this function, final 'height' is of no use
        int height = height(root, diameter);

        return diameter.value;
    }

    // to hold diameter through recursive calls
    private static class Diameter {
        int value = Integer.MIN_VALUE;
    }

    // helper, calculate max value of 'd'
    private static int height(Node<Integer> root, Diameter d) {

        if (root == null)
            return 0;

        int heightLeft = height(root.left, d);
        int heightRight = height(root.right, d);

        // updating max diameter
        d.value = Math.max(d.value, heightLeft + heightRight + 1);

        // 1 + max(leftHeight, rightHeight)
        return 1 + Math.max(heightLeft, heightRight);
    }

    public static void main(String[] args) {
        System.out.println("Diameter: " + diameter(tree()));
    }

    // binary tree
    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);
        root.right = new Node(9);
        root.right.right = new Node(9);
        root.right.right.left = new Node(5);
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
