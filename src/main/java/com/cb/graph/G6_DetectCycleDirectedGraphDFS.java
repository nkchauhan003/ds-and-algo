package com.cb.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G6_DetectCycleDirectedGraphDFS {
    public static boolean isLoopPresent(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        boolean[] visitedSameRecur = new boolean[v];

        // to handle disconnected graph
        for (int i = 0; i < v; i++)
            if (!visited[i] && cycleInComponent(adj, visited, visitedSameRecur, i))
                return true;

        return false;
    }

    public static boolean cycleInComponent(
            List<List<Integer>> adj, boolean[] visited, boolean[] visSameRecur, int start) {

        visited[start] = true;
        visSameRecur[start] = true;

        boolean flag = false;
        for (int it : adj.get(start)) {
            if (visSameRecur[it])
                return true;
            else if (!visited[it])
                flag = flag || cycleInComponent(adj, visited, visSameRecur, it);
        }

        // mark unvisited for next recursion
        visSameRecur[start] = false;
        return flag;
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

        adj.get(7).add(8);

        adj.get(8).add(6);


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
