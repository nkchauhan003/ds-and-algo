package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n*n)
 * Space: O(n) for call stack
 * */
public class BT17_CheckIfBinaryTreeIsSumTree {
    private static boolean isSumTree(Node<Integer> root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        return (root.data == sum(root.left) + sum(root.right)) && isSumTree(root.left)
                && isSumTree(root.right);
    }

    private static int sum(Node<Integer> root) {
        if (root == null)
            return 0;

        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.data;
    }

    public static void main(String[] args) {
        isSumTree(tree());
    }

    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.left = new Node(9);

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
