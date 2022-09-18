package com.cb.arrays;

/*
 * Duplicate element(s) in non-sorted array
 * Time: O(n)
 * Space: O(1)
 * Handles "0s" and more than two occurrence of an element
 * */
public class A12_FindDuplicatesInLinearTimeConstantExtraSpace_1 {

    public static void printDuplicates(int arr[], int n) {

        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = n + arr[arr[i] % n];

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 2 * n)
                System.out.print(i + " ");
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 1, 3, 0, 1, 3, 4};
        printDuplicates(arr, arr.length);
    }
}


