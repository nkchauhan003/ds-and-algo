package com.cb.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class A0_TwoSum_N_AND_N {
    public static int[] twoSum(int[] input, int x) {

        // array value -> array index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(input[0], 0);

        for (int i = 1; i < input.length; i++) {
            if (map.containsKey(x - input[i]))
                return new int[]{map.get(x - input[i]), i};
            else
                map.put(input[i], i);
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
