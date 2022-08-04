package com.cb.binarytree;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Recursion
 * Time: O(n)
 * Space: O(n) for Map
 * */
public class BT10_PrintTopViewOfBinaryTree {

    // to store nodes grouped by 'Horizontal Distance'
    private static Map<Integer, List<Node<Integer>>> map = new TreeMap<>();

    // prints topView
    private static void printTopView(Node<Integer> root) {
        if (root == null)
            return;
        groupByHorizontalDistance(root, 0);

        // printing comma separated - first value of each list
        System.out.println(map.values().stream().map(i -> i.get(0).data.toString()).collect(Collectors.joining(",")));
    }

    // traversing level order to group nodes by "HorizontalDistance"
    private static void groupByHorizontalDistance(Node<Integer> root, int hd) {

        if (map.containsKey(hd)) {
            // do nothing
            // we need only the first(top) value of a vertical
        } else {
            List<Node<Integer>> nodes = new ArrayList<>();
            nodes.add(root);
            map.put(hd, nodes);
        }

        if (root.left != null)
            groupByHorizontalDistance(root.left, hd - 1);
        if (root.right != null)
            groupByHorizontalDistance(root.right, hd + 1);
    }

    public static void main(String[] args) {
        printTopView(tree());
    }

    // binary tree
    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.left = new Node(9);
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
