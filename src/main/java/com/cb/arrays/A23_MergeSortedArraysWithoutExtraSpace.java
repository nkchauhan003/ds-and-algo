package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time: O(n1 * n2)
 * Time: O(1)
 * */
public class A23_MergeSortedArraysWithoutExtraSpace {
    public static void merge(long[] a1, int n1, long[] a2, int n2) {

        for (int i = 0; i < n1; i++) {
            if (a1[i] > a2[0]) {
                long tmp = a1[i];
                a1[i] = a2[0];
                a2[0] = tmp;

                // insertion sort
                int j = 1;
                long t = a2[0];
                while (j < n2 && t > a2[j]) {
                    a2[j - 1] = a2[j];
                    j++;
                }
                a2[--j] = t;
            }
        }
    }


    public static void main(String[] args) {

        long a1[] = {1, 3, 5, 7};
        long a2[] = {0, 2, 6, 8, 9};
        printArray(a1);
        printArray(a2);
        merge(a1, a1.length, a2, a2.length);
        printArray(a1);
        printArray(a2);

    }

    private static void printArray(long[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Long::toString).collect(Collectors.joining(",")));
    }
}
