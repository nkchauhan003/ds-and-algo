package com.cb.recursion;

/*
 * Recursion
 * */
public class R8_CheckIfArrayIsSorted {
    public static boolean isSorted(int arr[], int start, int end) {

        // entire array is traversed
        if (start >= end)
            return true;

        // non-sorted condition is detected
        if (arr[start] > arr[start + 1])
            return false;

        // check for remaining array
        return isSorted(arr, ++start, end);
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5}, 0, 4));
        System.out.println(isSorted(new int[]{1, 2, 2, 4, 5}, 0, 4));
        System.out.println(isSorted(new int[]{1}, 0, 0));
        System.out.println(isSorted(new int[]{1, 5}, 0, 1));
        System.out.println(isSorted(new int[]{5, 1, 2, 3}, 0, 3));
    }
}
