package com.cb.dp;

/*
 * Memoization
 * Print LCS
 * Time Complexity: n*m
 * */
public class Dp9_PrintLongestCommonSubsequence {
    public static String lcs(String s1, String s2, int n, int m, String[][] t) {

        if (n == 0 || m == 0)
            return "";

        if (t[n][m] != null)
            return t[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return t[n][m] = lcs(s1, s2, n - 1, m - 1, t) + s1.charAt(n - 1);

        return t[n][m] = maxByLength(lcs(s1, s2, n - 1, m, t), lcs(s1, s2, n, m - 1, t));
    }

    private static String maxByLength(String a, String b) {
        return a.length() > b.length() ? a : b;
    }

    public static void main(String[] args) {

        String s1 = "acbcf";
        String s2 = "abcdaf";

        int n = s1.length();
        int m = s2.length();

        String[][] t = new String[n + 1][m + 1];

        System.out.println(lcs(s1, s2, n, m, t)); //abcf
    }
}
