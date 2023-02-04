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
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int lengthSoFar = 0;
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                int inx= map.get(c);
                while (i <= inx) {
                    map.remove(s.charAt(i));
                    i++;
                }
                map.put(c, j);
            } else {
                map.put(c, j);
                lengthSoFar = Math.max(lengthSoFar, map.size());
            }
            j++;
        }
        return lengthSoFar;
    }
    
    public static void main(String[] args) {
        String s = "umvejcuuk";
        System.out.println(longestSubstring(s));// false
    }
}
