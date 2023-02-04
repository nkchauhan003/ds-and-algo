package com.cb.string;

import java.util.HashSet;
import java.util.Set;

/*
 * Time complexity: O(n*n)
 * Space complexity: O(n*n)
 * */
public class S18_LongestSubstringWithoutRepeatingCharacters_n2_and_n2 {

    private static int longestSubstring(String s) {
        int n = s.length();
        int longestSoFar = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    longestSoFar = Math.max(set.size(), longestSoFar);
                } else {
                    break;
                }
            }
        }
        return longestSoFar;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstring(s));// 3
    }
}
