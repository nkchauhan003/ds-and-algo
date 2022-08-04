package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for call stack
 * */
public class BT5_InOrderTraversalOfBinaryTree {

    // prints in-order
    private static void inorder(Node<Integer> root) {
        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.data + ", ");

        inorder(root.right);
    }


    public static void main(String[] args) {
        inorder(tree());
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
