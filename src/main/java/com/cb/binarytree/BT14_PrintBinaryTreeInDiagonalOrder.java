package com.cb.binarytree;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Recursion + Map
 * Time: O(n)
 * Space: O(n) for Map
 * */
public class BT14_PrintBinaryTreeInDiagonalOrder {

    private static Map<Integer, List<Node<Integer>>> map = new TreeMap<>();

    // prints diagonally
    private static void printDiagonally(Node<Integer> root, int d) {
        if (root == null)
            return;
        fillMap(root, d);

        // prints map
        map.forEach(
                (k, v) -> System.out.println(v.stream().map(i -> i.data.toString()).collect(Collectors.joining(","))));
    }

    // group node diagonally
    private static void fillMap(Node<Integer> root, int d) {
        if (root == null)
            return;
        if (map.containsKey(d))
            map.get(d).add(root);
        else {
            List<Node<Integer>> list = new ArrayList();
            list.add(root);
            map.put(d, list);
        }
        fillMap(root.left, d + 1);
        fillMap(root.right, d);
    }

    public static void main(String[] args) {
        printDiagonally(tree(), 0);
    }

    // binary tree
    private static Node<Integer> tree() {
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
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
