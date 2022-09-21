package com.cb.recursion;

/*
 * Recursion
 * Print SCS
 * Time Complexity: O(2^(m+n))
 * */
public class R29_PrintShortestCommonSuperSequence {
    public static String lcs(String s1, String s2, int n, int m) {

        if (n == 0)
            return s2.substring(0, m);

        if (m == 0)
            return s1.substring(0, n);

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return lcs(s1, s2, n - 1, m - 1) + s1.charAt(n - 1);

        String lcsN = lcs(s1, s2, n, m - 1);
        String lcsM = lcs(s1, s2, n - 1, m);

        return lcsN.length() > lcsM.length() ? lcsM + s1.charAt(n - 1) : lcsN + s2.charAt(m - 1);
    }

    private static String min(String a, String b) {
        return a.length() > b.length() ? b : a;
    }

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int n = s1.length();
        int m = s2.length();

        System.out.println(lcs(s1, s2, n, m)); //AGGXTXAYB
    }
}
