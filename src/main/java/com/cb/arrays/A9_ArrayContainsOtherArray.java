package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * O(n*m)
 * */
public class A9_ArrayContainsOtherArray {
    private static boolean contains(int[] arr, int[] subArr) {
        int n = arr.length;
        int m = subArr.length;

        for (int i = 0; i < n; i++) {
            int j = i, k = 0;
            while (k < m && j < n && arr[j] == subArr[k]) {
                if (k == m - 1)
                    return true;
                j++;
                k++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(contains(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 4})); // true
        System.out.println(contains(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6})); // false
        System.out.println(contains(new int[]{1, 2, 3, 2, 3, 4}, new int[]{2, 3, 4})); // true
    }
}
