package com.cb.recursion;

/*
 * Recursion
 * Matrix Chain Multiplication
 * Time Complexity: Exponential O(2^n)
 * */
public class R32_MatrixChainMultiplication {
    public static int mcm(int[] arr, int l, int h) {
        if (l >= h - 1)
            return 0;

        int k = l + 1;
        int minCost = Integer.MAX_VALUE;

        for (; k < h; k++) {
            // cost-left + cost-right + costOf(left*right)
            int totalCost = mcm(arr, l, k) + mcm(arr, k, h) + (arr[l] * arr[k] * arr[h]);

            if (totalCost < minCost)
                minCost = totalCost;
        }
        return minCost;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{
                40, 20, 30, 10, 30
        };

        System.out.println(mcm(arr, 0, arr.length - 1));
    }
}
