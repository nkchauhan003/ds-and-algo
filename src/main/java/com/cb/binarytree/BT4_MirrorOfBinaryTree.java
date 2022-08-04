package com.cb.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for call stack
 * */
public class BT4_MirrorOfBinaryTree {

    // converts a tree into its mirror
    private static Node mirror(Node<Integer> root) {
        if (root == null)
            return null;

        Node leftTree = mirror(root.left);
        Node rightTree = mirror(root.right);

        root.left = rightTree;
        root.right = leftTree;

        return root;
    }
    
    public static void main(String[] args) {
        Node treeMirror = mirror(tree());

        // testing
        traverse(treeMirror); // 1,3,2,5,4
    }

    // for testing only
    private static void traverse(Node<Integer> tree) {
        Queue<Node> queue = new LinkedList<>();
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

    // binary tree
    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(5);
        root.right.right.left = new Node(4);
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
