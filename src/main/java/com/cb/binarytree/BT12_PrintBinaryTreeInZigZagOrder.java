package com.cb.binarytree;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Using two Stacks
 * Time: O(n)
 * Space: O(n+n) ~ O(n) for auxiliary stacks
 * */
public class BT12_PrintBinaryTreeInZigZagOrder {

    // prints in ZigZag
    private static void printInZigZag(Node<Integer> root) {
        if (root == null)
            return;

        Stack<Node<Integer>> evenLevel = new Stack<>();
        evenLevel.add(root);

        Stack<Node<Integer>> oddLevel = new Stack<>();

        while (!evenLevel.empty() || !oddLevel.isEmpty()) {
            while (!evenLevel.empty()) {
                Node node = evenLevel.pop();
                System.out.print(node.data + ", ");
                if (node.left != null)
                    oddLevel.add(node.left);
                if (node.right != null)
                    oddLevel.add(node.right);

            }
            while (!oddLevel.empty()) {
                Node node = oddLevel.pop();
                System.out.print(node.data + ", ");
                if (node.right != null)
                    evenLevel.add(node.right);
                if (node.left != null)
                    evenLevel.add(node.left);
            }
        }
    }

    public static void main(String[] args) {
        printInZigZag(tree());
    }

    // binary tree
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
