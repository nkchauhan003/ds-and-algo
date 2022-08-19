package com.cb.recursion;

/*
 * Recursion
 * LCS
 * Time Complexity: n^2
 * */
public class R24_LongestCommonSubsequence {
    public static int lcs(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0)
            return 0;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + lcs(s1, s2, n - 1, m - 1);

        return max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {

        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        int n = s1.length();
        int m = s2.length();

        System.out.println(lcs(s1, s2, n, m)); //4
    }
}
