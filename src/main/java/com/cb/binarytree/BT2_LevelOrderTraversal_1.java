package com.cb.binarytree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * O(n)
 * Using extra space O(n)- Map
 * */
public class BT2_LevelOrderTraversal_1 {

    // Map to hold level wise tree-nodes
    private static Map<Integer, List<Node>> map = new LinkedHashMap<>();

    private static void traverseLevelOrder(Node<Integer> tree) {
        populateMap(tree, 0);

        // printing "map"
        System.out.println(map.values().stream().flatMap(List::stream).map(v -> String.valueOf(v.data)).collect(
                Collectors.joining(",")));
    }

    // populating map to hold level wise tree-nodes
    private static void populateMap(Node<Integer> tree, int level) {
        if (tree == null)
            return;

        if (map.containsKey(level))
            map.get(level).add(tree);
        else {
            var nodes = new ArrayList<Node>();
            nodes.add(tree);
            map.put(level, nodes);
        }

        populateMap(tree.left, level + 1);
        populateMap(tree.right, level + 1);
    }

    public static void main(String[] args) {
        traverseLevelOrder(tree());
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
