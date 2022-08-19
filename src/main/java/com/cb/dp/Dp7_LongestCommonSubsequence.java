package com.cb.dp;

/*
 * Recursion
 * LCS
 * Time Complexity: n*m
 * */
public class Dp7_LongestCommonSubsequence {
    public static int lcs(String s1, String s2, int n, int m, int[][] t) {

        if (n == 0 || m == 0) return 0;

        if (t[n][m] != -1) return t[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) return t[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, t);

        return t[n][m] = max(lcs(s1, s2, n - 1, m, t), lcs(s1, s2, n, m - 1, t));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int n = s1.length();
        int m = s2.length();

        int[][] t = new int[n + 1][m + 1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }

        System.out.println(lcs(s1, s2, n, m, t)); //4
    }
}
