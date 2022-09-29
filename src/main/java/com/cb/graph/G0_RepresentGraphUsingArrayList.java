package com.cb.graph;

import java.util.ArrayList;
import java.util.List;

public class G0_RepresentGraphUsingArrayList {

    public List<List<Integer>> graph() {

        // n = vertex, m = edges
        int n = 3, m = 3;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++)
            adj.add(new ArrayList<>());

        // edge 1--2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 1--3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // edge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        return adj;
    }
}
