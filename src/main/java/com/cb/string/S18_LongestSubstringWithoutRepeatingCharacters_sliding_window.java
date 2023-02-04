package com.cb.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Time complexity: O(n)
 * Space complexity: O(1)
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

                // new window start
                i = map.get(c) + 1;

                // change index to new element
                map.put(c, j);

                // new window length so far
                lengthTillHere = j - i + 1;
            } else {
                // add new element
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
