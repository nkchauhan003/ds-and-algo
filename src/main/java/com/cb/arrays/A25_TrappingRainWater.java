package com.cb.arrays;

/*
 * Time: O(n)
 * Space: O(n)
 * */
public class A25_TrappingRainWater {

    private static long trappingWater(int arr[], int n) {

        long[] minLeftRight = new long[n];
        long maxSoFar = 0;

        for (int i = 0; i < n; i++) {
            minLeftRight[i] = maxSoFar;
            if (arr[i] > maxSoFar)
                maxSoFar = arr[i];
        }

        maxSoFar = 0;

        long water = 0;
        for (int i = n - 1; i >= 0; i--) {
            minLeftRight[i] = Math.min(maxSoFar, minLeftRight[i]);
            long w = minLeftRight[i] - arr[i];
            if (w > 0)
                water += w;
            if (arr[i] > maxSoFar)
                maxSoFar = arr[i];

        }
        return water;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 0, 0, 2, 0};
        System.out.println(trappingWater(arr, arr.length)); // 5
    }
}
