package com.cb.dp;

/*
 * Memoization
 * SCS
 * Time Complexity: n*m
 * */
public class Dp10_ShortestCommonSuperSequence {
    public static int lcs(String s1, String s2, int n, int m, Integer[][] t) {

        if (n == 0)
            return m;

        if (m == 0)
            return n;

        if (t[n][m] != null)
            return t[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return t[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, t);

        // this +1 is for space occupied by character from min length lcs
        return t[n][m] = 1 + min(lcs(s1, s2, n - 1, m, t), lcs(s1, s2, n, m - 1, t));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "xycd";

        int n = s1.length();
        int m = s2.length();

        Integer[][] t = new Integer[n + 1][m + 1];

        System.out.println(lcs(s1, s2, n, m, t)); //6
    }
}
