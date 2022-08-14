package com.cb.dp;

/*
 * Memoization
 * 0/1 Knapsack
 * Time Complexity: n*w
 * */
public class Dp1_01KnapsackProblem_Memoization {
    private static int knapsackRec(
            int[] weight, int[] value,
            int capacity, int n, int[][] t) {

        // base condition
        if (n == 0 || capacity == 0)
            return 0;

        // check if already calculated
        if (t[n][capacity] != -1)
            return t[n][capacity];

        if (weight[n - 1] <= capacity)
            // store in table before return
            return t[n][capacity] = max((value[n - 1] + knapsack(weight, value,
                    capacity - weight[n - 1], n - 1)), knapsack(weight, value, capacity, n - 1));
        else
            // store in table before return
            return t[n][capacity] = knapsack(weight, value, capacity, n - 1);
    }

    public static int knapsack(
            int[] weight, int[] value,
            int capacity, int n) {

        // table to memoize
        int[][] t = new int[n + 1][capacity + 1];

        // initialize table with -1
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }
        return knapsackRec(weight, value, capacity, n, t);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int n = weight.length;
        int capacity = 50;

        System.out.println(knapsack(weight, value, capacity, n)); // 220
    }
}
