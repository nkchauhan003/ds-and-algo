package com.cb.binarytree;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for call stack
 * */
public class BT18_CheckIfBinaryTreeIsHasLeavesAtSameLevel {
    private static int leafLevel = -1;
    private static int diff = 0;

    private static boolean check(Node root) {
        traverse(root, 0);
        return diff == 0;
    }

    private static void traverse(Node root, int level) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (leafLevel == -1)
                leafLevel = level;
            else if (leafLevel != level) {
                diff++;
            }
        }
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);

    }

    public static void main(String[] args) {
        var result = check(tree());
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
