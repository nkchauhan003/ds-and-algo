package com.cb.arrays;

/*
 * Kadane's Algorithm
 * Time: O(n)
 * Space: O(1)
 * */
public class A8_KadanesAlgorithm_1 {
    public static int contiguousSubArray(int arr[], int n) {
        int bestSum = arr[0], currentSum = arr[0];

        for (int i = 1; i < n; i++) {
            currentSum = max(arr[i], currentSum + arr[i]);
            bestSum = max(bestSum, currentSum);
        }

        return bestSum;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        System.out.println(contiguousSubArray(arr, arr.length)); // -1

        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(contiguousSubArray(arr1, arr1.length)); // 6
    }
}
