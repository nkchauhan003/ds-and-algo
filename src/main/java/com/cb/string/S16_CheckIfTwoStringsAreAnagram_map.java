package com.cb.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Time complexity: O(n)
 * Space complexity: O(Number of distinct characters)
 * */
public class S16_CheckIfTwoStringsAreAnagram_map {

    private static boolean isAnagram(String s1, String s2, int n, int m) {

        if (n != m)
            return false;

        Map<Character, Integer> chars = new HashMap();

        for (int i = 0; i < n; i++) {
            Character c = s1.charAt(i);
            if (chars.containsKey(c))
                chars.put(c, chars.get(c) + 1);
            else
                chars.put(c, 1);

            c = s2.charAt(i);
            if (chars.containsKey(c))
                chars.put(c, chars.get(c) - 1);
            else
                chars.put(c, -1);
        }

        // if map contains any non-zero value return "false"
        return !chars.values().stream().anyMatch(i -> i != 0);
    }


    public static void main(String[] args) {
        String s1 = "act";
        String s2 = "cat";
        System.out.println(isAnagram(s1, s2, s1.length(), s2.length()));// true
    }
}
