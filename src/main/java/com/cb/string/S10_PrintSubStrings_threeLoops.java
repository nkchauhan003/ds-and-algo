package com.cb.string;

/*
 * Print all substrings of a string
 * Time: O(n^3)
 * Space: O(1)
 * Iterative
 * */
public class S10_PrintSubStrings_threeLoops {

    private static void substrings(String s, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++)
                    System.out.print(s.charAt(k));
                System.out.print(",");
            }
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        substrings(s, s.length());
    }
}
