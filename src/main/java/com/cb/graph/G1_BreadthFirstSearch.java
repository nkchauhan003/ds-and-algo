package com.cb.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G1_BreadthFirstSearch {

    public static List<Integer> breadthFirstSearch(int v, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int[] visited = new int[v];

        queue.add(0);
        while (!queue.isEmpty()) {
            int e = queue.poll();
            if (visited[e] > 0)
                continue;
            ans.add(e);
            visited[e] = 1;

            if (!adj.get(e).isEmpty())
                queue.addAll(adj.get(e));
        }
        return ans;
    }

    public static void main(String[] args) {
        int v = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(4);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);

        System.out.println(breadthFirstSearch(v, adj));
    }
}
