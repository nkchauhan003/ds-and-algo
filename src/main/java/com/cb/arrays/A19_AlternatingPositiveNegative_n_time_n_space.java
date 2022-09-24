package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Alternating positive & negative
 * Maintaining the order
 * Time: O(n)
 * Space: O(n)
 * */
public class A19_AlternatingPositiveNegative_n_time_n_space {
    public static void rearrange(int arr[], int n) {

        int tmp[] = new int[n];
        int i = 0, j = -1, k = n;
        while (i < n) {
            if (arr[i] >= 0)
                tmp[--k] = arr[i];
            else
                tmp[++j] = arr[i];
            i++;
        }
        int mid = j;

        i = -1;
        j = 0;
        k = n - 1;
        while (i < n - 1) {
            if (j <= mid)
                arr[++i] = tmp[j++];
            if (k > mid)
                arr[++i] = tmp[k--];
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -4, -1, 4};
        int n = arr.length;

        printArray(arr);
        rearrange(arr, n);
        printArray(arr); // -5,5,-2,2,-8,4,7,1,8,0
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
