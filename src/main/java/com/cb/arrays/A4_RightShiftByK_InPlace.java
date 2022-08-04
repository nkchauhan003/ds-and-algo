package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Rotate Right
 * In_Place
 * */
public class A4_RightShiftByK_InPlace {
    private static void shift(int[] arr, int n, int k) {

        // if 'k' is invalid
        if (k < 1)
            return;

        // if 'k' is greater that the length of array
        if (k > n)
            k = k % n;
        
        // move last k elements to aux array
        for (int i = 0; i < k; i++) {
            int tmp = arr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = tmp;
        }
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

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
