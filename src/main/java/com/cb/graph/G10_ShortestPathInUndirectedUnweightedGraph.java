package com.cb.graph;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G10_ShortestPathInUndirectedUnweightedGraph {
    public static int[] shortestPath(List<List<Integer>> adj, int v, int source) {
        int[] distance = new int[v];

        for (int i = 0; i < distance.length; i++)
            distance[i] = Integer.MAX_VALUE;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        distance[0] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int in : adj.get(node)) {
                if (distance[in] > 1 + distance[node]) {
                    distance[in] = 1 + distance[node];

                    // process an adjacent node only if it's distance is changed
                    q.add(in);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int v = 6;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);

        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(3);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(3);
        adj.get(4).add(1);

        printArray(shortestPath(adj, v, 0));
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

}
