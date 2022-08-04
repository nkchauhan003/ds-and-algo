package com.cb.arrays;

/*
 * Kadane's Algorithm
 * Time: O(n)
 * Space: O(1)
 * */
public class A8_KadanesAlgorithm {
    public static void contiguousSubArray(int arr[], int n) {

        // Start of contiguous-SubArray
        int start = 0, newStart = 0;

        // End of contiguous-SubArray
        int end = 0;
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < n; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                newStart = i + 1;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = newStart;
                end = i;
            }
        }
        System.out.println("Sub-array: { " + print(arr, start, end) + "}, Sum: " + maxSoFar);
    }

    // Just to print sub-array
    private static String print(int[] arr, int start, int end) {
        String s = "";
        for (int i = start; i <= end; i++)
            s += arr[i] + " ";
        return s;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        contiguousSubArray(arr, arr.length);

        int[] arr1 = {1};
        contiguousSubArray(arr1, arr1.length);

        int[] arr2 = {5, 4, -1, 7, 8};
        contiguousSubArray(arr2, arr2.length);

        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        contiguousSubArray(arr3, arr3.length);
    }
}
