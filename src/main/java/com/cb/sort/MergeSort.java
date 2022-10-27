package com.cb.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time: O(n log n)
 * Space: O(n)
 * */
public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int n = mid - low + 1;
        int m = high - mid;

        int[] left = new int[n];
        int[] right = new int[m];

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
                arr[k] = right[j];
                j++;
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
    }

    public static void main(String[] args) {
        int arr[] = {38, 27, 43, 3, 9, 82, 10};
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
