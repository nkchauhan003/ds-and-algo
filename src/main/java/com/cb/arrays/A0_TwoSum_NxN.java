package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time Complexity: O(n*n)
 * */
public class A0_TwoSum_NxN {
    public static int[] twoSum(int[] input, int target) {
        for (int i = 0; i < input.length; i++)
            for (int j = i + 1; j < input.length; j++) {
                if (target - (input[i] + input[j]) == 0)
                    return new int[]{i, j};
            }
        return new int[]{-1, -1};
    }

    // Testing
    public static void main(String[] args) {
        printArray(twoSum(new int[]{1, 4, 45, 6, 10, 8}, 16));  //[3,4]
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Long::toString).collect(Collectors.joining(",")));
    }
}
