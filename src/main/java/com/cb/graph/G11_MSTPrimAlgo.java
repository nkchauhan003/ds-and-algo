package com.cb.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * */
public class G11_MSTPrimAlgo {
    public static int minimumWeight(List<List<Node>> adj, int v) {

        boolean[] visitedNodes = new boolean[v];

        // O(n long n)
        // will make sure, edge with less weight is visited first
        Queue<Node> queue = new PriorityQueue<>();
        // we need to connect all nodes, therefore can start from any
        queue.add(new Node(0, 0));

        int totalWeight = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visitedNodes[node.num])
                continue;
            visitedNodes[node.num] = true;
            totalWeight += node.weight;

            queue.addAll(adj.get(node.num));
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        int v = 5;

        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 2));
        adj.get(0).add(new Node(3, 6));

        adj.get(1).add(new Node(0, 2));
        adj.get(1).add(new Node(3, 8));
        adj.get(1).add(new Node(4, 5));
        adj.get(1).add(new Node(2, 3));

        adj.get(2).add(new Node(1, 3));
        adj.get(2).add(new Node(4, 7));

        adj.get(3).add(new Node(0, 6));
        adj.get(3).add(new Node(1, 8));

        adj.get(4).add(new Node(1, 5));
        adj.get(4).add(new Node(2, 7));

        System.out.println(minimumWeight(adj, v));
    }

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight < o.weight)
                return -1;
            if (this.weight > o.weight)
                return 1;
            return 0;
        }
    }
}
