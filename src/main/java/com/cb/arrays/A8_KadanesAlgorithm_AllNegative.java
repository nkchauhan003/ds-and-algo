package com.cb.arrays;

/*
 * Kadane's Algorithm (All Negative)
 * Time: O(n)
 * Space: O(1)
 * */
public class A8_KadanesAlgorithm_AllNegative {
    public static long contiguousSubArray(int arr[], int n) {

        // Start of contiguous-SubArray
        int start = 0, newStart = 0;

        // End of contiguous-SubArray
        int end = 0;
        long maxSoFar = arr[0];
        long maxEndingHere = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere += arr[i];

            if (maxEndingHere < arr[i]) {
                maxEndingHere = arr[i];
                newStart = i;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = newStart;
                end = i;
            }
        }
        System.out.println("Sub-array: { " + print(arr, start, end) + "}, Sum: " + maxSoFar);
        return maxSoFar;
    }

    // Just to print sub-array
    private static String print(int[] arr, int start, int end) {
        String s = "";
        for (int i = start; i <= end; i++)
            s += arr[i] + " ";
        return s;
    }


    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        System.out.println(contiguousSubArray(arr, arr.length)); // -1

        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(contiguousSubArray(arr1, arr1.length)); // 7
    }
}
