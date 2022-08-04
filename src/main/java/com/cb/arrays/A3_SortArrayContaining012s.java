package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Linear O(n)
 * Dutch National Flag
 * */
public class A3_SortArrayContaining012s {

    public static void sort(int[] arr, int n) {
        // check if input is correct
        if (arr == null || n < 1)
            return;

        int low = 0, mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap start
                int tmp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = tmp;
                // Swap end
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                // Swap start
                int tmp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = tmp;
                // Swap end

                high--; // pushing 2s at the end
            }
        }
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 0, 0, 1, 2, 1, 0};
        sort(arr, arr.length);
        printArray(arr);


        int[] arr1 = {1, 0, 0};
        sort(arr1, arr1.length);
        printArray(arr1);
    }
}
