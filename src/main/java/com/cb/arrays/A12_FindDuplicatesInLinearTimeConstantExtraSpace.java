package com.cb.arrays;

/*
 * Duplicate element(s) in non-sorted array
 * Time: O(n)
 * Space: O(1)
 * Does not handle "0s" and more than two occurrence of an element
 * */
public class A12_FindDuplicatesInLinearTimeConstantExtraSpace {

    public static void printDuplicates(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            // element at index = current element
            var v = arr[Math.abs(arr[i])];
            if (v < 0)
                System.out.print(Math.abs(arr[i]) + " ");
            else
                arr[Math.abs(arr[i])] = -v;
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1, 3, 4};
        printDuplicates(arr, arr.length);
    }
}


