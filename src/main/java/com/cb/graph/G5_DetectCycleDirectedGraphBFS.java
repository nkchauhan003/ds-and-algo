package com.cb.graph;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Time: O(v+e)
 * Space: O(v)
 * Kahn's Algorithm
 * */
public class G5_DetectCycleDirectedGraphBFS {
    public static boolean hasCycle(List<List<Integer>> adj, int v) {
        int[] inDegree = new int[v];

        //finding in-degrees
        for (int i = 0; i < v; i++)
            for (int in : adj.get(i))
                inDegree[in]++;

        // add node with Zero degree to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        int ai = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ai++;
            // decrease in-degree for adjacent nodes
            for (int in : adj.get(node)) {
                inDegree[in]--;

                // add to queue if inDegree==0
                if (inDegree[in] == 0)
                    q.add(in);
            }
        }
        return !(ai == v);
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
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(7).add(8);
        adj.get(8).add(6);

        System.out.println(hasCycle(adj, v)); // true
    }
}
