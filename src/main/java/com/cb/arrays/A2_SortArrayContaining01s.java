package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * O(n)
 * Dutch National Flag
 * */
public class A2_SortArrayContaining01s {
    private static void sort(int[] arr, int n) {
        if (arr == null || n < 1)
            return;

        int low = 0, high = n - 1;
        while (low < high) {
            if (arr[low] == 0)
                low++;
            else if (arr[low] == 1) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                high--;
            }
        }
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0};
        sort(arr, arr.length);
        printArray(arr);

        int[] arr1 = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        sort(arr1, arr1.length);
        printArray(arr1);
    }
}
