package com.cb.binarytree;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Queue
 * Time: O(n)
 * Space: O(n) for Queue
 * */
public class BT14_PrintBinaryTreeInDiagonalOrder_1 {

    // prints diagonally
    private static void printDiagonally(Node<Integer> root) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node<Integer> node = queue.poll();
                System.out.print(node.data + ", ");
                if (node.left != null)
                    queue.add(node.left);

                while (node.right != null) {
                    node = node.right;

                    if (node.left != null)
                        queue.add(node.left);
                    System.out.print(node.data + ", ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDiagonally(tree());
    }

    // binary tree
    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
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
