package com.cb.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class S18_LongestSubstringWithoutRepeatingCharacters_sliding_window {

    private static int longestSubstring(String s) {
        int n = s.length();

        // value and index
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int lengthSoFar = 0, lengthTillHere = 0;

        while (i < n && j < n) {
            char c = s.charAt(j);

            // not before window start
            if (map.containsKey(c) && map.get(c) >= i) {
                i = map.get(c) + 1;
                map.put(c, j);
                lengthTillHere = j - i + 1;
            } else {
                map.put(c, j);
                lengthTillHere += 1;
                lengthSoFar = Math.max(lengthSoFar, lengthTillHere);
            }
            j++;
        }
        return lengthSoFar;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(longestSubstring(s));// false
    }
}
