package com.cb.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G3_DetectCycleUndirectedGraphBFS {
    public static boolean isLoopPresent(List<List<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];

        // to handle disconnected graph
        for (int i = 0; i < v; i++) {
            if (visited[i])
                continue;
            if (cycleInComponent(adj, visited, i))
                return true;
        }
        return false;
    }

    public static boolean cycleInComponent(List<List<Integer>> adj, boolean[] visited, int start) {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(new Node<>(-1, start));

        while (!q.isEmpty()) {
            Node<Integer> node = q.poll();

            if (visited[node.current])
                continue;

            visited[node.current] = true;
            int prev = node.prev;

            for (int it : adj.get(node.current)) {
                if (visited[it] && it != prev)
                    return true;
                else
                    q.add(new Node<>(node.current, it));
            }
        }
        return false;
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
