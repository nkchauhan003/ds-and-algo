package com.cb.dp;

/*
 * Memoization
 * Longest Common Substring
 * Time Complexity: n*m*l
 * */
public class Dp8_LongestCommonSubstring {
    public static int lcSubStr(String s1, String s2, int n, int m, int l, Integer[][][] t3d) {

        if (n == 0 || m == 0)
            return l;

        int lForT3d = l;

        if (t3d[n][m][l] != null)
            return t3d[n][m][l];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            l = lcSubStr(s1, s2, n - 1, m - 1, l + 1, t3d);

        // length for new sub-string including s1
        int lnIncludingS1 = lcSubStr(s1, s2, n, m - 1, 0, t3d);

        // length for new sub-string including s2
        int lnIncludingS2 = lcSubStr(s1, s2, n - 1, m, 0, t3d);

        return t3d[n][m][lForT3d] = max(l, lnIncludingS1, lnIncludingS2);
    }

    public static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        if (b >= a && b >= c)
            return b;
        return c;
    }

    public static void main(String[] args) {

        String s1 = "zxabcdezy";
        String s2 = "yzabcdezx";
        int n = s1.length();
        int m = s2.length();
        int l = n < m ? n : m;

        Integer[][][] t3d = new Integer[n + 1][m + 1][l + 1];

        System.out.println(lcSubStr(s1, s2, n, m, 0, t3d)); //6
    }
}
