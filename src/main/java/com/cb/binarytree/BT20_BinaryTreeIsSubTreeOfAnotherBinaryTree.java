package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n*m)
 * Space: O(n) for call stack
 * */
public class BT20_BinaryTreeIsSubTreeOfAnotherBinaryTree {
    private static boolean isSubtree(Node<Integer> tree, Node<Integer> subTree) {
        if (subTree == null)
            return true;
        if (tree == null)
            return false;
        if (equalNodes(tree, subTree))
            return isSubtree(tree.left, subTree.left) && isSubtree(tree.right, subTree.right);
        else
            return isSubtree(tree.left, subTree) || isSubtree(tree.right, subTree);
    }

    private static boolean equalNodes(Node a, Node b) {
        return ((a == null && b == null) || (a != null && b != null && a.data == b.data));
    }


    public static void main(String[] args) {
        System.out.println(isSubtree(tree(), subTree()));
    }

    private static Node<Integer> subTree() {
        Node<Integer> root = new Node(2);
        root.left = new Node(4);
        root.right = new Node(5);
        return root;
    }

    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

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
