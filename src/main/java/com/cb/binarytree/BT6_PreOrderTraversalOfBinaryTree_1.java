package com.cb.binarytree;

import java.util.Stack;

/*
 * Iteration
 * Time: O(n)
 * Space: O(n) for auxiliary stack
 * */
public class BT6_PreOrderTraversalOfBinaryTree_1 {

    // prints pre-order
    private static void preorder(Node<Integer> root) {
        if (root == null)
            return;
        Stack<Node<Integer>> s = new Stack();
        s.push(root);

        while (!s.empty()) {
            Node<Integer> node = s.pop();
            System.out.print(node.data + ", ");
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
    }


    public static void main(String[] args) {
        preorder(tree());
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
