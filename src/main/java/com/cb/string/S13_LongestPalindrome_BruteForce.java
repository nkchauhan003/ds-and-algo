package com.cb.string;

/*
 * Longest Palindrome
 * Time complexity: O(n^3)
 * Recursion
 * */
public class S13_LongestPalindrome_BruteForce {

    private static String longestPalindrome(String s, int n) {
        String longestSoFar = "";
        for (int i = 0; i < n; i++) {
            String ss = "";
            for (int j = i; j < n; j++) {
                ss += s.charAt(j);
                if (isPalindrome(ss)) longestSoFar = max(longestSoFar, ss);
            }
        }
        return longestSoFar;
    }

    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    private static String max(String a, String b) {
        return a.length() >= b.length() ? a : b;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s, s.length())); // bab
    }
}
