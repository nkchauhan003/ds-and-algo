package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time: O(n+m)
 * Space: O(1)
 * */
public class A7_IntersectionOfTwoSortedArrays {
    private static void printIntersection(int[] a, int[] b, int n1, int n2) {
        int i = 0, j = 0;

        n1 = removeDuplicate(a, n1);
        n2 = removeDuplicate(b, n2);

        // while both arrays have elements to traverse
        while (i < n1 && j < n2) {

            // Print only if both arrays have common element
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else if (a[i] <= b[j])
                i++;
            else
                j++;
        }
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).
                collect(Collectors.joining(",")));
    }

    // works for sorted arrays only
    private static int removeDuplicate(int[] a, int n) {
        if (n < 2)
            return n;

        int uniqueIndex = 0;
        int lastUniqueElement = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] != lastUniqueElement) {
                uniqueIndex++;
                a[uniqueIndex] = a[i];
                lastUniqueElement = a[i];
            }
        }
        return uniqueIndex + 1;
    }

    // Test
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6};
        int[] b = {1, 2, 3, 5};
        printIntersection(a, b, a.length, b.length); // 1 3

        System.out.println();

        int[] a1 = {11, 33, 62, 105};
        int[] b1 = {1, 11, 105, 620};
        printIntersection(a1, b1, a1.length, b1.length); // 11 105
    }
}
