package com.cb.string;

/*
 * Print all substrings of a string
 * Time complexity: O(n^3)
 * Space: O(1)
 * Iterative
 * */
public class S10_PrintSubStrings_UsingSubstringFn {

    private static void substrings(String s, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(s.substring(i, j + 1) + ", ");
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        substrings(s, s.length());
    }
}
