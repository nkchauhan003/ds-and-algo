package com.cb.arrays;

/*
 * Kadane's Algorithm (All Negative)
 * Time: O(n)
 * Space: O(1)
 * */
public class A8_KadanesAlgorithm_AllNegative {
    public static long contiguousSubArray(int arr[], int n) {
        long bestSum = arr[0], currentSum = arr[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }


    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        System.out.println(contiguousSubArray(arr, arr.length)); // -1

        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(contiguousSubArray(arr1, arr1.length)); // 7
    }
}
