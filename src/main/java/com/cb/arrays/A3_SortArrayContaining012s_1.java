package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * O(n)
 * Counting 0s,1s and 2s
 * */
public class A3_SortArrayContaining012s_1 {

    public static void sort(int[] arr, int n) {
        int noOf0s = 0;
        int noOf1s = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                noOf0s++;
            else if (arr[i] == 1)
                noOf1s++;
        }

        for (int i = 0; i < n; i++) {
            if (noOf0s-- > 0)
                arr[i] = 0;
            else if (noOf1s-- > 0)
                arr[i] = 1;
            else
                arr[i] = 2;
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
