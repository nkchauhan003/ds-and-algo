package com.cb.dp;

/*
 * Memoization
 * Unbounded Knapsack
 * Time Complexity: n*w
 * */
public class Dp5_UnboundedKnapsackProblem {
    public static int knapsack(
            int[] weight, int[] value,
            int capacity, int n, int[][] t) {

        if (n == 0 || capacity == 0)
            return 0;

        // check if already calculated
        if (t[n][capacity] != -1)
            return t[n][capacity];

        if (weight[n - 1] <= capacity)
            return t[n][capacity] = max((value[n - 1] + knapsack(weight, value,
                    capacity - weight[n - 1], n, t)), knapsack(weight, value, capacity, n - 1, t));
        else
            return t[n][capacity] = knapsack(weight, value, capacity, n - 1, t);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {10, 40, 50, 70};
        int n = weight.length;
        int capacity = 8;
        // table to memoize
        int[][] t = new int[n + 1][capacity + 1];

        // initialize table with -1
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(knapsack(weight, value, capacity, n, t));
    }
}
