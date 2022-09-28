package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Print all Permutations
 * Time: O(n * !n)
 * Time: O(n) used by recursion stack
 * */
public class A22_PrintAllPermutations_Array_constantSpace {
    public static void permutations(int[] arr, int n, int i) {
        if (i == n - 1) {
            printArray(arr);
            return;
        }

        for (int j = i; j < n; j++) {
            // no need to create a copy as we are reverting the swapping at the end
            //int cp[] = Arrays.copyOf(arr, n);
            swap(arr, i, j);
            permutations(arr, n, i + 1);

            // to avoid extra space
            swap(arr, j, i);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int n = arr.length;
        permutations(arr, n, 0);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
