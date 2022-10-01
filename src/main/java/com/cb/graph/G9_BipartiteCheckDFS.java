package com.cb.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Time: O(v+e)
 * Space: O(v)
 * Kahn's Algorithm
 * */
public class G9_BipartiteCheckDFS {
    public static boolean isBipartite(List<List<Integer>> adj, int v) {

        // 0-not visited, 1-color1, 2-color2
        int[] color = new int[v];

        for (int i = 0; i < v; i++)
            if (color[i] == 0 && !isBipartiteRecur(adj, v, color, i, 1))
                return false;

        return true;
    }

    public static boolean isBipartiteRecur(List<List<Integer>> adj, int v, int[] color, int node, int parentColor) {
        boolean flag = true;
        if (color[node] == 0) {
            color[node] = parentColor == 0 ? 1 : 0;
            for (int in : adj.get(node))
                flag = flag && isBipartiteRecur(adj, v, color, in, color[node]);
        } else {
            if (color[node] == parentColor)
                return false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int v = 7;

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

        System.out.println(isBipartite(adj, v)); // true
    }

}
