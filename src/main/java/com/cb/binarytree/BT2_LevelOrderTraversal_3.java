package com.cb.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * O(n * n)
 * Using two functions
 * */
public class BT2_LevelOrderTraversal_3 {

    // traverse tree level by level
    private static void traverseLevelOrder(Node<Integer> tree) {
        int height = height(tree);
        for (int i = 0; i <= height; i++) {
            printOneLevel(tree, i, 0);
        }
    }

    // prints one level
    private static void printOneLevel(Node<Integer> tree, int levelToPrint, int level) {

        if (levelToPrint < level || tree == null)
            return;
        if (levelToPrint == level)
            System.out.print(tree.data + ", ");

        printOneLevel(tree.left, levelToPrint, level + 1);
        printOneLevel(tree.right, levelToPrint, level + 1);
    }

    private static int height(Node<Integer> root) {

        if (root == null)
            return -1;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        // 1 + max(leftHeight, rightHeight)
        return 1 + (heightLeft > heightRight ? heightLeft : heightRight);
    }

    public static void main(String[] args) {
        traverseLevelOrder(tree());
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
