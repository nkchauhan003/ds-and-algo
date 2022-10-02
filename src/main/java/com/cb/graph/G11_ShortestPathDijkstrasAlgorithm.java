package com.cb.graph;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G11_ShortestPathDijkstrasAlgorithm {
    public static int[] shortestPath(List<List<Node>> adj, int v, Node source) {
        int[] distance = new int[v];

        for (int i = 0; i < distance.length; i++)
            distance[i] = Integer.MAX_VALUE;

        Queue<Node> q = new LinkedList<>();
        q.add(source);
        distance[0] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (Node in : adj.get(node.num)) {
                if (distance[in.num] > distance[node.num] + in.weight) {
                    distance[in.num] = in.weight + distance[node.num];
                    // process an adjacent node only if it's distance is changed
                    q.add(in);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int v = 6;

        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 1));

        adj.get(1).add(new Node(0, 1));
        adj.get(1).add(new Node(2, 2));
        adj.get(1).add(new Node(4, 4));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(5, 10));
        adj.get(2).add(new Node(3, 2));

        adj.get(3).add(new Node(2, 2));
        adj.get(3).add(new Node(4, 1));

        adj.get(4).add(new Node(3, 1));
        adj.get(4).add(new Node(1, 4));

        adj.get(5).add(new Node(2, 10));

        printArray(shortestPath(adj, v, new Node(0, 0)));
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    static class Node {
        int num;
        int weight;

        public Node(
                int num,
                int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
