package com.cb.binarytree;

import java.util.*;

/*
 * O(n)
 * Using extra space O(n)- Queue
 * */
public class BT2_LevelOrderTraversal_2 {

    // queue to hold tree-nodes
    private static Queue<Node> queue = new LinkedList<>();

    private static void traverseLevelOrder(Node<Integer> tree) {
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + ",");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
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
