package com.cb.recursion;

/*
 * Recursion
 * SCS
 * Time Complexity: n^2
 * */
public class R27_ShortestCommonSuperSequence {
    public static int lcs(String s1, String s2, int n, int m) {

        if (n == 0)
            return m;

        if (m == 0)
            return n;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + lcs(s1, s2, n - 1, m - 1);

        // this +1 is for space occupied by character from min length lcs
        return 1 + min(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int n = s1.length();
        int m = s2.length();

        System.out.println(lcs(s1, s2, n, m)); //4
    }
}
