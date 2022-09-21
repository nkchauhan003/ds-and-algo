package com.cb.recursion;

/*
 * Recursion
 * Longest Palindromic Subsequence
 * Time Complexity: O(2^(m+n))
 * */
public class R34_LongestPalindromicSubsequence {
    public static int longestPalindromicSubsequence(String s, int n) {
        return lcs(s, reverse(s), n, n);
    }

    public static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + lcs(s1, s2, n - 1, m - 1);

        return max(lcs(s1, s2, n, m - 1), lcs(s1, s2, n - 1, m));
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }


    // time complexity O(n)
    public static String reverse(String s) {
        String rs = "";
        for (int i = s.length() - 1; i > -1; i--) {
            rs += s.charAt(i);
        }
        return rs;
    }

    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestPalindromicSubsequence(s, s.length())); // 7
    }
}
