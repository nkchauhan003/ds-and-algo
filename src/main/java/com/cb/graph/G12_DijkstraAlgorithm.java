package com.cb.graph;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Time: O(V2)
 * Space: O(V2)
 * */
public class G12_DijkstraAlgorithm {
    public static int[] shortestPath(List<List<Node>> adj, int v, int source) {

        int[] shortestPaths = new int[v];
        for (int i = 0; i < v; i++)
            shortestPaths[i] = Integer.MAX_VALUE;
        shortestPaths[source] = 0;

        // O(n long n)
        // will make sure, edge with less weight is visited first
        Queue<Node> queue = new PriorityQueue<>();
        // we need to connect all nodes, therefore can start from any
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node it : adj.get(node.num))
                if (shortestPaths[node.num] + it.weight < shortestPaths[it.num]) {
                    shortestPaths[it.num] = shortestPaths[node.num] + it.weight;
                    queue.add(new Node(it.num, shortestPaths[it.num]));
                }
        }
        return shortestPaths;
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

        printArray(shortestPath(adj, v, 0));
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
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
