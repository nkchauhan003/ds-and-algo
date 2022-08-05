package com.cb.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Recursion
 * Time: O(n*n)
 * Space: O(n) for call stack
 * */
public class BT16_ConstructBinaryTreeFromInorderAndPreorder {

    private static int preOrderIndex = 0;

    // construct tree
    private static Node constructTree(int[] inOrder, int[] preOrder, int inStart, int inEnd) {

        if (inStart > inEnd)
            return null;

        // root
        Node<Integer> node = new Node(preOrder[preOrderIndex++]);

        // if no left and right
        if (inStart == inEnd)
            return node;

        int divideIndex = search(inOrder, inStart, inEnd, node.data);

        node.left = constructTree(inOrder, preOrder, inStart, divideIndex - 1);
        node.right = constructTree(inOrder, preOrder, divideIndex + 1, inEnd);

        return node;
    }

    // linear search
    private static int search(int arr[], int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    public static void main(String[] args) {

        int[] inOrder = {4, 2, 5, 1, 3, 6};
        int[] preOrder = {1, 2, 4, 5, 3, 6};

        Node root = constructTree(inOrder, preOrder, 0, inOrder.length - 1);
        traverseLevelOrder(root);
    }

    // User by traverseLevelOrder()
    private static Queue<Node> queue = new LinkedList<>();

    // just to print the binary tree
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
