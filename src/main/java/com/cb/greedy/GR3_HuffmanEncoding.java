package com.cb.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/*
* Time: O(nlogn)
* Space: O(1)
* */
public class GR3_HuffmanEncoding {

    private static Node huffmanTree(String s, int f[], int n) {

        // sorted queue
        PriorityQueue<Node> queue = new PriorityQueue<>(n, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.f - o2.f;
            }
        });

        for (int i = 0; i < n; i++)
            queue.add(new Node(f[i], s.charAt(i)));

        Node root = null;
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();

            root = new Node(left.f + right.f, null);
            root.left = left;
            root.right = right;

            queue.add(root);
        }
        return root;

    }

    private static void huffmanTreeInorder(Node root, String code, List<String> codes) {
        if (root == null)
            return;
        huffmanTreeInorder(root.left, code + "0", codes);
        if (root.c != null) {
            System.out.println(root.c + " : " + code);
            codes.add(code);
        }
        huffmanTreeInorder(root.right, code + "1", codes);


    }

    public static void main(String[] args) {
        String s = "abcdef";
        int f[] = {5, 9, 12, 13, 16, 45};
        int n = s.length();
        List list = new ArrayList();
        huffmanTreeInorder(huffmanTree(s, f, n), "", list);
        System.out.println(list);
    }

    // tree-node
    static class Node {
        Node left;
        Node right;
        Integer f;
        Character c;

        public Node(
                Integer f, Character c) {
            this.f = f;
            this.c = c;
        }
    }
}
