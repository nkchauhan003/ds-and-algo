package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n2)
 * Space: O(n) for call stack
 * */
public class BT3_DiameterOfBinaryTree {

    // returns diameter or width
    private static int diameter(Node<Integer> root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        // returns max of (leftDia, rightDia, longest path between leaves that goes through the root)
        return Math.max((1 + leftHeight + rightHeight), Math.max(leftDiameter, rightDiameter));
    }

    // helper, returns height of a tree
    private static int height(Node<Integer> root) {
        
        if (root == null)
            return 0;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        // 1 + max(leftHeight, rightHeight)
        return 1 + (heightLeft > heightRight ? heightLeft : heightRight);
    }

    public static void main(String[] args) {
        System.out.println("Diameter: " + diameter(tree()));
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
