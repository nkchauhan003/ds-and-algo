package com.cb.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for Queue
 * */
public class BT8_PrintLeftViewOfBinaryTree_1 {
    // prints leftView
    private static void printLeftView(Node<Integer> root) {
        if (root == null)
            return;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();

                // prints only first element of a level
                if (i == 0)
                    System.out.print(node.data + ", ");

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        printLeftView(tree());
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
