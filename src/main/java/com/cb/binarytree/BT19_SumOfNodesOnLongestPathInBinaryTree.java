package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for call stack
 * */
public class BT19_SumOfNodesOnLongestPathInBinaryTree {
    private static int sumSoFar = 0;
    private static int maxLevel = -1;

    private static int sumOfLongRootToLeafPath(Node<Integer> root) {
        levelOrder(root, 0, 0);
        return sumSoFar;
    }

    private static void levelOrder(Node<Integer> root, int level, int sum) {
        if (root == null)
            return;

        sum = sum + root.data;
        if (maxLevel < level) {
            maxLevel = level;
            sumSoFar = sum;
        }
        if (maxLevel == level && sumSoFar < sum)
            sumSoFar = sum;

        levelOrder(root.left, level + 1, sum);
        levelOrder(root.right, level + 1, sum);
    }

    public static void main(String[] args) {
        var result = sumOfLongRootToLeafPath(tree());
        System.out.println(result);
    }

    private static Node<Integer> tree() {
        Node<Integer> root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
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
