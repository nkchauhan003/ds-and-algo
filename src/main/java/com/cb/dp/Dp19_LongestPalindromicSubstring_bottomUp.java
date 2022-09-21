package com.cb.dp;

/*
 * DP BottomUp
 * Longest Palindromic Substring
 * Time: O(n^2)
 * Space: O(n^2)
 * */
public class Dp19_LongestPalindromicSubstring_bottomUp {

    public static int longestPalindromicSubstring(String s, int n) {

        boolean t[][] = new boolean[n][n];

        int longestLength = 1;

        // O(n)
        // single element is already a palindrome of size 1
        for (int i = 0; i < n; i++) {
            int j = i;
            t[i][j] = true;
        }

        // O(n)
        // string with two elements is a palindrome if both corner elements are equal
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                t[i][j] = true;
                longestLength = 2;
            }
        }

        // O(n-2 * n-2) ~ O(n*n)
        // for substrings of length >= 3
        // string is a palindrome if both corner elements are equal and subString in between is also equal
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (t[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    t[i][j] = true;
                    longestLength = k;
                }
            }
        }

        return longestLength;
    }

    public static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        if (b >= a && b >= c)
            return b;
        return c;
    }


    public static void main(String[] args) {
        String s = "abcbab";
        System.out.println(longestPalindromicSubstring(s, s.length())); // 5
    }
}
