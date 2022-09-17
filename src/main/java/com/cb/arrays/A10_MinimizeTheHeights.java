package com.cb.arrays;

import java.util.Arrays;

public class A10_MinimizeTheHeights {

    public static int minDiff(int arr[], int n, int k) {
        // sort the array
        Arrays.sort(arr);

        int minHeight = arr[0], maxHeight = arr[n - 1];
        int minDiff = maxHeight - minHeight;

        for (int i = 1; i < n; i++) {

            // height can not be negative
            if (arr[i] - k < 0)
                continue;

            minHeight = Math.min(arr[0] + k, arr[i] - k);
            maxHeight = Math.max(arr[n - 1] - k, arr[i - 1] + k);

            minDiff = Math.min(minDiff, maxHeight - minHeight);
        }
        return minDiff;
    }


    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 10};
        int k = 2;
        System.out.println(minDiff(arr, arr.length, k));
    }
}


