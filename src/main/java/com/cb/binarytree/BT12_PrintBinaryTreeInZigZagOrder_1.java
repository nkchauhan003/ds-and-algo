package com.cb.binarytree;

import java.util.*;

/*
 * Using Queue & List
 * Time: O(n)
 * Space: O(n)
 * */
public class BT12_PrintBinaryTreeInZigZagOrder_1 {

    // prints in ZigZag
    private static void printInZigZag(Node<Integer> root) {
        if (root == null)
            return;
        Queue<Node<Integer>> q = new LinkedList();
        q.add(root);

        boolean evenLevel = true;

        while (!q.isEmpty()) {
            int size = q.size();

            List<Node<Integer>> nodesFromOneLevel = new ArrayList<>();
            // traverse queue for last level nodes
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                nodesFromOneLevel.add(n);

                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }
            if (evenLevel) {
                // next will be odd
                evenLevel = false;
            } else {
                // need to print right to left for odd levels
                Collections.reverse(nodesFromOneLevel);
                // next will be even
                evenLevel = true;
            }
            nodesFromOneLevel.forEach(i -> System.out.print(i.data + ","));
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
