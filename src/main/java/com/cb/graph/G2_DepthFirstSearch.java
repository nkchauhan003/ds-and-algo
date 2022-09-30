package com.cb.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Time: O(v+e)
 * Space: O(v)
 * */
public class G2_DepthFirstSearch {

    public static List<Integer> dfs(int v, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[v];

        dfsRecur(0, adj, ans, visited);
        return ans;
    }

    public static void dfsRecur(int element, List<List<Integer>> adj, List<Integer> ans, int[] visited) {
        if (visited[element] > 0)
            return;
        visited[element] = 1;
        ans.add(element);
        for (int i = 0; i < adj.get(element).size(); i++)
            dfsRecur(adj.get(element).get(i), adj, ans, visited);
    }

    public static void main(String[] args) {
        int v = 6;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(4);
        adj.get(2).add(5);

        System.out.println(dfs(v, adj));
    }
}
