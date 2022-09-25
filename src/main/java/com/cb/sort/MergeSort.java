package com.cb.sort;

import java.util.Arrays;

public class MergeSort {
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int pIndex = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                int tmp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = tmp;
                pIndex++;
            }
        }
        int tmp = arr[pIndex];
        arr[pIndex] = arr[high];
        arr[high] = tmp;
        return pIndex;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            sort(arr, low, pIndex - 1);
            sort(arr, pIndex + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 4, 1, 6};
        sort(arr, 0, arr.length - 1);
        // printing array
        System.out.println(Arrays.toString(arr));
    }
}
