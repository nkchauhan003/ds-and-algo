package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Rotate Right
 * Reversal Algorithm
 * */
public class A4_RightShiftByK_Reversal {

    private static void shift(int[] arr, int n, int k) {
        // reverse arr[1 to n-k]
        reverse(arr, 0, n - k - 1);

        // reverse arr[n-k+1 to n]
        reverse(arr, n - k, n - 1);

        // reverse arr[1 to n]
        reverse(arr, 0, n - 1);
    }

    // utility fn to reverse an array
    private static void reverse(int a[], int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    // test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        shift(arr, arr.length, k);
        printArray(arr);

        int[] arr1 = {10, 20, 43, 12, 7, 123};
        int k1 = 2;
        shift(arr1, arr1.length, k1);
        printArray(arr1);
    }
}
