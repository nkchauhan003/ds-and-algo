package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * O(n), Simple Approach
 * */
public class A2_SortArrayContaining01s_1 {

    private static void sort(int[] arr, int n) {
        if (arr == null || n < 1)
            return;

        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] == 1) {
                while (arr[j] == 1 && j > i)
                    j--;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            i++;
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
