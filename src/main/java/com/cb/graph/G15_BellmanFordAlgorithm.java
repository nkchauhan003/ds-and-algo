package com.cb.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Time: O(N*E)
 * Space: O(N)
 * */
public class G15_BellmanFordAlgorithm {
    public static int[] shortestPath(List<List<Node>> adj, int v, int source) {

        int[] shortestPaths = new int[v];

        for (int i = 0; i < v; i++)
            shortestPaths[i] = 10000000;
        shortestPaths[source] = 0;

        // relax n-1 times
        for (int i = 0; i < v; i++) {

            for (int j = 0; j < v; j++) {
                for (var node : adj.get(j)) {
                    if (shortestPaths[j] + node.weight < shortestPaths[node.num])
                        shortestPaths[node.num] = shortestPaths[j] + node.weight;
                }
            }

        }
        return shortestPaths;
    }

    public static void main(String[] args) {
        int v = 6;

        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 5));

        adj.get(1).add(new Node(5, -3));
        adj.get(1).add(new Node(2, -2));

        adj.get(2).add(new Node(4, 3));

        adj.get(3).add(new Node(4, -2));
        adj.get(3).add(new Node(2, 6));

        adj.get(5).add(new Node(3, 1));

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
            if (this.weight < o.weight) return -1;
            if (this.weight > o.weight) return 1;
            return 0;
        }
    }
}
