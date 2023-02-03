package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Time Complexity: O(n * log n)
 * */
public class A0_TwoSum_NxlogN {
    public static int[] twoSum(int[] input, int x) {
        Arrays.sort(input);
        int i = 0, j = input.length - 1;
        while (i < j) {
            int diff = x - (input[i] + input[j]);
            if (diff < 0)
                j--;
            else if (diff > 0)
                i++;
            else
                return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }

    // Testing
    public static void main(String[] args) {
        printArray(twoSum(new int[]{6, 4, 3, 9, 5}, 13));  //[1,3]
    }

    // Just to print output array
    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Long::toString).collect(Collectors.joining(",")));
    }
}
