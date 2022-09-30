package com.cb.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G4_DetectCycleUndirectedGraphDFS {
    public static boolean isLoopPresent(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];

        // to handle disconnected graph
        for (int i = 0; i < v; i++)
            if (!visited[i] && cycleInComponent(adj, visited, i, -1))
                return true;

        return false;
    }

    public static boolean cycleInComponent(List<List<Integer>> adj, boolean[] visited, int start, int prev) {
        visited[start] = true;

        boolean isLoop = false;
        for (int i = 0; i < adj.get(start).size(); i++) {
            if (visited[adj.get(start).get(i)] && adj.get(start).get(i) != prev)
                return true;
            else if (!visited[adj.get(start).get(i)])
                isLoop = isLoop || cycleInComponent(adj, visited, adj.get(start).get(i), start);
        }

        return isLoop;
    }

    public static void main(String[] args) {
        int v = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);

        adj.get(1).add(0);
        adj.get(1).add(4);
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(3);
        adj.get(4).add(1);

        System.out.println(isLoopPresent(adj, v));
    }

    public static class Node<T> {
        T prev;
        T current;

        public Node(
                T prev,
                T current) {
            this.prev = prev;
            this.current = current;
        }
    }
}
