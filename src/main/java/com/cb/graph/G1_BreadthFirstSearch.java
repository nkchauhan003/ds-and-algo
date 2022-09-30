package com.cb.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G1_BreadthFirstSearch {

    public static List<Integer> breadthFirstSearch(int v, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int[] visited = new int[v];

        q.add(0);
        while (!q.isEmpty()) {
            int e = q.poll();
            if (visited[e] > 0)
                continue;
            ans.add(e);
            visited[e] = 1;

            if (!adj.get(e).isEmpty())
                q.addAll(adj.get(e));
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
