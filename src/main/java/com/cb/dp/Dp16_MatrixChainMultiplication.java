package com.cb.dp;

/*
 * Memoization
 * Matrix Chain Multiplication
 * Time Complexity: Exponential O(n^3)
 * */
public class Dp16_MatrixChainMultiplication {
    public static int mcm(int[] arr, int l, int h, int[][] t) {
        if (l >= h - 1)
            return 0;

        if (t[l][h] > 0)
            return t[l][h];
        int k = l + 1;
        int minCost = Integer.MAX_VALUE;

        for (; k < h; k++) {
            // cost-left + cost-right + costOf(left*right)
            int totalCost = mcm(arr, l, k, t) + mcm(arr, k, h, t) + (arr[l] * arr[k] * arr[h]);

            if (totalCost < minCost)
                minCost = totalCost;
        }
        return t[l][h] = minCost;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{
                40, 20, 30, 10, 30
        };
        int n = arr.length;
        int l = 0, h = n - 1;
        int[][] t = new int[n][n];

        System.out.println(mcm(arr, 0, h, t));
    }
}
