package com.cb.binarytree;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Using extra Map
 * Time: O(n)
 * Space: O(n) for auxiliary Map
 * */
public class BT11_PrintBinaryTreeInVerticalOrder {

    // to store nodes grouped by 'Horizontal Distance'
    private static Map<Integer, List<Node<Integer>>> map = new TreeMap<>();

    // prints vertically
    private static void printInVerticalOrder(Node<Integer> root) {
        if (root == null)
            return;

        groupByHorizontalDistance(root, 0);
        map.forEach(
                (k, v) -> System.out.println(v.stream().map(i -> i.data.toString()).collect(Collectors.joining(","))));
    }

    // traversing level order to group node by "HorizontalDistance"
    private static void groupByHorizontalDistance(Node<Integer> root, int hd) {

        if (map.containsKey(hd))
            map.get(hd).add(root);
        else {
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
        printInVerticalOrder(tree());
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
