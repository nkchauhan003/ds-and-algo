package com.cb.string;

/*
 * Print all substrings of a string
 * Time: O(n^2)
 * Space: O(n)
 * Iterative
 * */
public class S10_PrintSubStrings_twoLoops {

    private static void substrings(String s, int n) {
        for (int i = 0; i < n; i++) {
            String ss = "";
            for (int j = i; j < n; j++) {
                ss += s.charAt(j);
                System.out.print(ss + ",");
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        substrings(s, s.length());
    }
}
