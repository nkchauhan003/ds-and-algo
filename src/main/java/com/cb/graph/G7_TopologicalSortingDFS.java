package com.cb.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G7_TopologicalSortingDFS {
    public static int[] topologicalSort(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        // to handle disconnected graph
        for (int i = 0; i < v; i++)
            if (!visited[i])
                topSort(adj, visited, i, stack);

        int[] topOrder = new int[v];
        int in = 0;
        while (!stack.isEmpty())
            topOrder[in++] = stack.pop();

        return topOrder;
    }

    public static void topSort(
            List<List<Integer>> adj, boolean[] visited, int start, Stack<Integer> stack) {
        visited[start] = true;
        for (int it : adj.get(start)) {
            if (!visited[it])
                topSort(adj, visited, it, stack);
        }
        stack.push(start);
    }

    public static void main(String[] args) {
        int v = 9;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(5);
        adj.get(3).add(4);
        adj.get(5).add(4);
        adj.get(6).add(7);
        adj.get(8).add(6);

        printArray(topologicalSort(adj, v));
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
