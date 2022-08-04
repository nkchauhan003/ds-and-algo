package com.cb.binarytree;

/**
 * O(n)
 * Height of empty tree is -1, height of tree with one node is 0.
 */
public class BT1_HeightOfBinaryTree {

    private static int height(Node<Integer> root) {

        if (root == null)
            return -1;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        // 1 + max(leftHeight, rightHeight)
        return 1 + (heightLeft > heightRight ? heightLeft : heightRight);
    }

    public static void main(String[] args) {
        System.out.println("Height: " + height(tree()));
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
