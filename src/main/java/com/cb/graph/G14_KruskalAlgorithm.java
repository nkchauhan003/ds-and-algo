package com.cb.graph;

import java.util.*;

/*
 * Time: O(E LogE + E LogV) ~ O(E logE) or O(E logV)
 * Space: O(V + E)
 * */
public class G14_KruskalAlgorithm {
    public static int kruskalAlgo(List<Edge> edges, int v) {

        // O(n log n)
        Collections.sort(edges);

        TbDisjointSet disjointSet = new TbDisjointSet(v);

        List<Edge> mst = new ArrayList<>();
        int mstCost = 0;

        for (Edge e : edges) {
            if (disjointSet.findParent(e.a) == disjointSet.findParent(e.b))
                continue;
            mst.add(e);
            mstCost += e.weight;

            disjointSet.union(e.a, e.b);
        }

        System.out.println(mst);
        //[Edge{a=0, b=1, weight=2}, Edge{a=1, b=2, weight=3}, Edge{a=1, b=4, weight=5}, Edge{a=0, b=3, weight=6}]

        return mstCost;
    }

    public static void main(String[] args) {
        int v = 5;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(0, 3, 6));

        System.out.println(kruskalAlgo(edges, v)); // 16
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int weight;

        public Edge(
                int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight < o.weight) return -1;
            if (this.weight > o.weight) return 1;
            return 0;
        }

        @Override
        public String toString() {
            return "Edge{" + "a=" + a + ", b=" + b + ", weight=" + weight + '}';
        }
    }

    static class TbDisjointSet {

        private Map<Integer, Integer> parent = new HashMap<>();
        private Map<Integer, Integer> rank = new HashMap<>();

        public TbDisjointSet(int v) {
            for (int i = 0; i < v; i++) {
                parent.put(i, i);
                rank.put(i, 0);
            }
        }

        public void union(int a, int b) {
            int rootA = findParent(a);
            int rootB = findParent(b);

            // a and b already in same set
            if (rootA == rootB) return;

            // attach smaller tree under the deeper tree
            if (rank.get(rootA) > rank.get(rootB))
                parent.put(rootB, rootA);
            else if (rank.get(rootA) < rank.get(rootB))
                parent.put(rootA, rootB);
            else {
                parent.put(rootA, rootB);
                rank.put(rootB, rank.get(rootB) + 1);
            }
        }

        public int findParent(int a) {

            // path compression
            if (parent.get(a) != a) parent.put(a, findParent(parent.get(a)));
            return parent.get(a);
        }
    }
}


