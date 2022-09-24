package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Alternating positive & negative items
 * Maintaining the order
 * Time: O(n^3)
 * Space: O(1)
 * */
public class A19_AlternatingPositiveNegative_np3_time_constantSpace {
    public static void rearrange(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && arr[i] >= 0) {
                int j = -1;
                for (int k = i + 1; k < n; k++) {
                    if (arr[k] < 0) {
                        j = k;
                        break;
                    }
                }
                if (j > 0)
                    rotateByOne(arr, i, j);
            } else if (i % 2 != 0 && arr[i] < 0) {
                int j = -1;
                for (int k = i + 1; k < n; k++) {
                    if (arr[k] >= 0) {
                        j = k;
                        break;
                    }
                }
                if (j > 0)
                    rotateByOne(arr, i, j);
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; // -5,5,-2,2,-8,4,7,1,8,0
        int n = arr.length;

        printArray(arr);
        rearrange(arr, n);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    private static void rotateByOne(int[] arr, int i, int j) {
        int jthElement = arr[j];
        for (int k = j; k > i; k--)
            arr[k] = arr[k - 1];

        arr[i] = jthElement;
    }
}
