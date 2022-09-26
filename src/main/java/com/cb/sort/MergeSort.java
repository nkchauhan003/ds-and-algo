package com.cb.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
    private static void mergeSort(int[] arr, int l, int h) {
        // single element
        if (l >= h)
            return;

        int mid = (h + l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, h);

        merge(arr, l, mid, h);
    }

    private static void merge(int[] arr, int l, int mid, int h) {

        int n = mid - l + 1;
        int m = h - mid;

        int left[] = new int[n];
        int right[] = new int[m];

        for (int i = 0; i < n; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0; i < m; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;

        int k = l;
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
