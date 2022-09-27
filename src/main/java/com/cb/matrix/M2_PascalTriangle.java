package com.cb.matrix;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time: O(n^2)
 * Space: O(n^2)
 * */
public class M2_PascalTriangle {

    private static void printPascalTriangle(int n) {

        int prev[] = null;
        // rows
        for (int r = 0; r < n; r++) {
            int arr[] = new int[r + 1];
            // columns
            for (int i = 0; i <= r; i++) {
                if (i == 0)
                    arr[i] = 1;
                else if (i == r)
                    arr[r] = 1;
                else
                    arr[i] = prev[i] + prev[i - 1];
            }
            printArray(arr);
            prev = arr;
        }
    }

    public static void main(String[] args) {
        printPascalTriangle(5);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
