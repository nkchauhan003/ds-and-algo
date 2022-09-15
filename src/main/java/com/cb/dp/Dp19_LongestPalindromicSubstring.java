package com.cb.dp;

/*
 * Memoization
 * Longest Palindromic Substring
 * Time Complexity: n*n
 * */
public class Dp19_LongestPalindromicSubstring {
    public static int longestPalindromicSubstring(String s, int n) {

        Integer[][][] t3d = new Integer[n + 1][n + 1][n + 1];
        return lcSubStr(s, reverse(s), n, n, 0, t3d);
    }

    public static int lcSubStr(String s1, String s2, int n, int m, int l, Integer[][][] t3d) {

        if (n == 0 || m == 0)
            return l;

        int lForT3d = l;

        if (t3d[n][m][lForT3d] != null)
            return t3d[n][m][lForT3d];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            l = lcSubStr(s1, s2, n - 1, m - 1, l + 1, t3d);

        // length for new sub-string including s1
        int lnIncludingS1 = lcSubStr(s1, s2, n, m - 1, 0, t3d);

        // length for new sub-string including s2
        int lnIncludingS2 = lcSubStr(s1, s2, n - 1, m, 0, t3d);

        return t3d[n][m][lForT3d] = max(l, lnIncludingS1, lnIncludingS2);
    }

    private static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        if (b > a && b > c)
            return b;
        return c;
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
        String s = "abcbab";
        System.out.println(longestPalindromicSubstring(s, s.length())); // 5
    }
}
