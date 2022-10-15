package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Linear Search
 * Time Complexity: O(n)
 * */
public class A1_FindMinAndMaxElement_LinearSearch {

    public static long[] findMinMax(long[] input) {

        // return [-1, -1] for invalid input array
        if (input == null || input.length < 1)
            return new long[]{-1, -1};

        // initialize with 0th element
        long min = input[0];
        long max = input[0];

        // start iteration from 2nd element
        for (int i = 1; i < input.length; i++) {
            if (input[i] > max)
                max = input[i];
            if (input[i] < min)
                min = input[i];
        }
        return new long[]{min, max};
    }

    // Testing
    public static void main(String[] args) {
        printArray(findMinMax(new long[]{})); // -1,-1
        printArray(findMinMax(new long[]{1, 2, 3, 4, 5})); // 1,5
        printArray(findMinMax(new long[]{1})); // 1,1
        printArray(findMinMax(new long[]{52, 94, 3, 18, 5})); // 3,94
    }

    // Just to print output array
    private static void printArray(long[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Long::toString).collect(Collectors.joining(",")));
    }
}
