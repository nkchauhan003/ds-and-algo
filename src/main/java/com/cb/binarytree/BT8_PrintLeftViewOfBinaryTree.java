package com.cb.binarytree;

import java.util.Stack;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for call stack
 * */
public class BT8_PrintLeftViewOfBinaryTree {

    // max level processed so far
    static int maxLevel = -1;

    // prints leftView
    private static void printLeftView(Node<Integer> root, int level) {
        if (root == null)
            return;
        if (level > maxLevel) {
            System.out.print(root.data + ", ");
            maxLevel = level;
        }
        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        printLeftView(tree(), 0);
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
