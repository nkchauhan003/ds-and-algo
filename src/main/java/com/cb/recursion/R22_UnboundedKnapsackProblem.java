package com.cb.recursion;

/*
 * Recursion
 * 0/1 Unbounded Knapsack
 * Time Complexity: 2^n
 * */
public class R22_UnboundedKnapsackProblem {
    public static int knapsack(
            int[] weight, int[] value,
            int capacity, int n) {

        if (n == 0 || capacity == 0)
            return 0;

        if (weight[n - 1] <= capacity)
            return max((value[n - 1] + knapsack(weight, value,
                    capacity - weight[n - 1], n)), knapsack(weight, value, capacity, n - 1));
        else
            return knapsack(weight, value, capacity, n - 1);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {10, 40, 50, 70};
        int n = weight.length;
        int capacity = 8;
        System.out.println(knapsack(weight, value, capacity, n));
    }
}
