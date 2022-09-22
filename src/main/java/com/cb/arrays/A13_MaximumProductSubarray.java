package com.cb.arrays;

/*
 * Maximum Product Sub-array
 * Time: O(n)
 * Space: O(1)
 * */
public class A13_MaximumProductSubarray {
    public static long contiguousProdSubArray(int arr[], int n) {

        if (arr == null || arr.length < 0)
            return 0;

        long maxEndingHere = arr[0];
        long minEndingHere = arr[0];
        long maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            // This variable is used so that the new value for 'maxEndingHere' does not change the calculation for 'minEndingHere'
            long tmpMaxEndingHere = max(maxEndingHere * arr[i], minEndingHere * arr[i], arr[i]);

            minEndingHere = min(maxEndingHere * arr[i], minEndingHere * arr[i], arr[i]);
            maxEndingHere = tmpMaxEndingHere;
            maxSoFar = max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

    public static long max(long a, long b, long c) {
        return Math.max(c, Math.max(a, b));
    }

    public static long max(long a, long b) {
        return Math.max(a, b);
    }

    public static long min(long a, long b, long c) {
        return Math.min(c, Math.min(a, b));
    }


    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        System.out.println(contiguousProdSubArray(arr, arr.length)); // 180
    }
}
