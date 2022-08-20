package com.cb.recursion;

/*
 * Recursion
 * Print LCS
 * Time Complexity: n^2
 * */
public class R26_PrintLCS {
    public static String lcs(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0)
            return "";

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return lcs(s1, s2, n - 1, m - 1) + s1.charAt(n - 1);

        return maxByLength(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }

    private static String maxByLength(String a, String b) {
        return a.length() > b.length() ? a : b;
    }

    public static void main(String[] args) {

        String s1 = "acbcf";
        String s2 = "abcdaf";
        int n = s1.length();
        int m = s2.length();

        System.out.println(lcs(s1, s2, n, m)); //4
    }
}
