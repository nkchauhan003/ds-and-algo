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

        // initialize with extreme values
        long min = Long.MAX_VALUE;
        long max = 0;

        // start iteration from 2nd element
        for (int i = 0; i < input.length; i++) {
            if (input[i] > max)
                max = input[i];
            if (input[i] < min)
                min = input[i];
        }
        return new long[]{min, max};
    }

    // Testing
    public static void main(String[] args) {
        printArray(findMinMax(new long[]{}));
        printArray(findMinMax(new long[]{1, 2, 3, 4, 5}));
        printArray(findMinMax(new long[]{1}));
        printArray(findMinMax(new long[]{52, 94, 3, 18, 5}));
    }

    // Just to print output array
    private static void printArray(long[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Long::toString).collect(Collectors.joining(",")));
    }
}
