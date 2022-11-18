package com.cb.arrays;

import java.util.Arrays;

/*
 * Time: O(n^2)
 * Space: O(1)
 * */
public class A26_TripletSum {

    private static boolean isTripletAvailable(int arr[], int n, int x) {

        if (n < 3)
            return false;

        // O(n log n)
        Arrays.sort(arr);

        // O(n*n)
        for (int i = 0; i < n; i++) {

            int j = i + 1, k = n - 1;
            while (j < k) {
                int tripleSum = arr[i] + arr[j] + arr[k];
                if (tripleSum == x)
                    return true;
                if (tripleSum < x)
                    j++;
                else
                    k--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 3, 6};
        int x = 10;
        System.out.println(isTripletAvailable(arr, arr.length, x)); // true

        int arr1[] = {1, 2, 4, 6};
        int x1 = 10;
        System.out.println(isTripletAvailable(arr1, arr1.length, x1)); // false
    }
}
