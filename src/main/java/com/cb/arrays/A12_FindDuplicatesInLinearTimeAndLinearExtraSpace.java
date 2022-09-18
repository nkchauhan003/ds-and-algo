package com.cb.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate element(s) in non-sorted array
 * Time: O(n)
 * Space: O(n)
 * Handles both "0s" and more than two occurrence of an element
 * */
public class A12_FindDuplicatesInLinearTimeAndLinearExtraSpace {

    public static List<Integer> printDuplicates(int arr[], int n, int tmp[]) {

        List<Integer> duplicates = new ArrayList<>();

        // keep track of count of all elements
        for (int i = 0; i < n; i++) {
            if (tmp[arr[i]] == 1)
                duplicates.add(arr[i]);
            tmp[arr[i]] = tmp[arr[i]] + 1;
        }

        // if no duplicate
        if (duplicates.size() < 1)
            duplicates.add(-1);

        return duplicates;
    }


    public static void main(String[] args) {
        int arr[] = {0, 3, 1, 2};
        int n = arr.length;
        System.out.println(printDuplicates(arr, n, new int[n])); //-1

        int arr1[] = {2, 3, 1, 0, 3, 2, 3, 0};
        int n1 = arr1.length;
        System.out.println(printDuplicates(arr1, n1, new int[n1])); // 3, 2, 0
    }
}


