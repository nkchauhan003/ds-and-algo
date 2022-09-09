package com.cb.dp;

/*
 * Print SCS
 * Time Complexity: n^m
 * */
public class Dp12_PrintShortestCommonSuperSequence {
    public static String lcs(String s1, String s2, int n, int m, String t[][]) {

        if (t[n][m] != null)
            return t[n][m];

        if (n == 0)
            return s2.substring(0, m);

        if (m == 0)
            return s1.substring(0, n);

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return t[n][m] = lcs(s1, s2, n - 1, m - 1, t) + s1.charAt(n - 1);

        String lcsN = lcs(s1, s2, n, m - 1, t);
        String lcsM = lcs(s1, s2, n - 1, m, t);

        return t[n][m] = lcsN.length() > lcsM.length() ? lcsM + s1.charAt(n - 1) : lcsN + s2.charAt(m - 1);
    }

    private static String min(String a, String b) {
        return a.length() > b.length() ? b : a;
    }

    public static void main(String[] args) {

        String s1 = "abac";
        String s2 = "cab";

        int n = s1.length();
        int m = s2.length();

        String t[][] = new String[n + 1][m + 1];

        System.out.println(lcs(s1, s2, n, m, t)); //cabac
    }
}
