package com.cb.dp;

/*
 * Memoization
 * Longest Palindromic Subsequence
 * Time Complexity: n*M
 * */
public class Dp18_LongestPalindromicSubsequence {
    public static int longestPalindromicSubsequence(String s, int n) {
        int[][] t = new int[n + 1][n + 1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }

        return lcs(s, reverse(s), n, n, t);
    }

    public static int lcs(String s1, String s2, int n, int m, int[][] t) {
        if (n == 0 || m == 0)
            return 0;
        if (t[n][m] != -1)
            return t[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return t[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, t);

        return t[n][m] = max(lcs(s1, s2, n, m - 1, t), lcs(s1, s2, n - 1, m, t));
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
