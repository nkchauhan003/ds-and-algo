package com.cb.string;

import java.util.HashSet;
import java.util.Set;

/*
 * Time complexity: O(n*n)
 * Space complexity: O(n*n)
 * */
public class S18_LongestSubstringWithoutRepeatingCharacters_n_and_n {

    private static int longestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int longestSoFar = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    longestSoFar = Math.max(set.size(), longestSoFar);
                    set = new HashSet<>();
                }
                {
                    set.add(s.charAt(j));
                }
            }
            longestSoFar = Math.max(set.size(), longestSoFar);
            set = new HashSet<>();
        }

        return longestSoFar;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstring(s));// false
    }
}
