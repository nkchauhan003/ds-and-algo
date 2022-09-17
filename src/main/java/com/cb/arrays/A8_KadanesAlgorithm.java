package com.cb.arrays;

/*
 * Kadane's Algorithm
 * Time: O(n)
 * Space: O(1)
 * */
public class A8_KadanesAlgorithm {
    public static int contiguousSubArray(int arr[], int n) {
        int bestSum = 0, currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum = max(0, currentSum + arr[i]);
            bestSum = max(bestSum, currentSum);
        }

        return bestSum;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }


    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(contiguousSubArray(arr, arr.length)); // 7
    }
}
