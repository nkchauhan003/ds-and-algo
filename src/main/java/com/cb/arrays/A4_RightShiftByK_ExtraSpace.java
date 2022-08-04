package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
/*
* Rotate Right
* Using extra space
* */
public class A4_RightShiftByK_ExtraSpace {
    private static void shift(int[] arr, int n, int k) {

        // if 'k' is invalid
        if (k < 1)
            return;

        // if 'k' is greater that the length of array
        if (k > n)
            k = k % n;

        int[] aux = new int[k];

        // move last k elements to aux array
        for (int i = 0; i <k; i++)
            aux[i] = arr[n-k+i];

        // move remaining elements to i+k index
        for (int i = n - k - 1; i >= 0; i--)
            arr[i + k] = arr[i];

        // put last k elements from 'aux' to start of 'arr'
        for (int i = 0; i < k; i++)
            arr[i] = aux[i];
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
