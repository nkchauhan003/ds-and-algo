package com.cb.binarytree;

import java.util.Stack;

/*
 * Stack
 * Time: O(n)
 * Space: O(n) for auxiliary Stack
 * */
public class BT5_InOrderTraversalOfBinaryTree_1 {

    // prints in-order
    private static void inorder(Node<Integer> root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.empty()) {

            // move to the leftest node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            Node node = stack.pop();
            System.out.print(node.data + ", ");

            // process right subtree
            curr = node.right;
        }
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
