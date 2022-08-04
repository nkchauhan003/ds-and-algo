package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Linear Search
 * */
public class A1_FindMinAndMaxElement_LinearSearch {

    public static int[] findMinMax(int[] input) {

        // return [-1, -1] for invalid input array
        if (input == null || input.length < 1)
            return new int[]{-1, -1};

        // initialize with 1st element or array
        int min = input[0];
        int max = input[0];

        // start iteration from 2nd element
        for (int i = 1; i < input.length; i++) {
            if (input[i] > max)
                max = input[i];
            if (input[i] < min)
                min = input[i];
        }
        return new int[]{min, max};
    }

    // Testing
    public static void main(String[] args) {
        printArray(findMinMax(new int[]{}));
        printArray(findMinMax(new int[]{1, 2, 3, 4, 5}));
        printArray(findMinMax(new int[]{1}));
        printArray(findMinMax(new int[]{52, 94, 3, 18, 5}));
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
