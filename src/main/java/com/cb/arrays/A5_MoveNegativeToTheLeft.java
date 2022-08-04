package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time: O(n)
 * Space: O(1)
 * */
public class A5_MoveNegativeToTheLeft {

    // Implementation
    private static void moveNegativeToLeft(int[] arr, int n) {
        if (arr == null || n < 1)
            return;

        int low = 0, high = n - 1;

        while (low < high) {
            if (arr[low] < 0)
                low++;
            else {
                swap(arr, low, high);
                high--;
            }
        }
    }

    // Just to swap
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6, 7};
        moveNegativeToLeft(arr, arr.length);
        printArray(arr);

        int[] arr1 = {23, -12, 4, 74, -1, 9, -45};
        moveNegativeToLeft(arr1, arr1.length);
        printArray(arr1);
    }
}
