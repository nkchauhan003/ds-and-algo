package com.cb.arrays;

/*
 * Time: O(n^2)
 * Space: O(n)
 * */
public class A24_CountInversionsInAnArray_n2 {

    public static long countInversion(long[] arr, int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        long arr[] = {1, 20, 6, 4, 5};
        System.out.println(countInversion(arr, arr.length));
    }
}
