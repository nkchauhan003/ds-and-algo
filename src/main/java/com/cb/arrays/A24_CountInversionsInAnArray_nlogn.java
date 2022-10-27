package com.cb.arrays;

/*
 * Time: O(n log n)
 * Space: O(n)
 * */
public class A24_CountInversionsInAnArray_nlogn {

    public static long mergeSortAndCount(long[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;

        long count = 0;

        count += mergeSortAndCount(arr, low, mid);
        count += mergeSortAndCount(arr, mid + 1, high);

        count += mergeAndCount(arr, low, mid, high);
        return count;
    }

    public static long mergeAndCount(long[] arr, int low, int mid, int high) {
        long count = 0;

        int n = mid - low + 1;
        int m = high - mid;

        long[] left = new long[n];
        long[] right = new long[m];

        for (int i = 0; i < n; i++)
            left[i] = arr[low + i];

        for (int j = 0; j < m; j++)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = low;

        while (i < n && j < m) {

            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                // left is greater than right
                arr[k] = right[j];
                j++;
                count += (mid + 1) - (low + i);
            }
            k++;

        }
        while (i < n) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < m) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return count;
    }

    public static void main(String[] args) {
        long arr[] = {1, 20, 6, 4, 5};
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }
}
