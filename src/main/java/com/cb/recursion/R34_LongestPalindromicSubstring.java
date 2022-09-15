package com.cb.recursion;

/*
 * Recursion
 * Longest Palindromic Substring
 * Time Complexity: 2^n
 * */
public class R34_LongestPalindromicSubstring {
    public static int longestPalindromicSubstring(String s, int n) {
        String s2 = reverse(s);
        int m = s2.length();
        return lcSubStr(s, reverse(s), n, m, 0);
    }

    public static int lcSubStr(String s1, String s2, int n, int m, int l) {

        if (n == 0 || m == 0)
            return l;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            l = lcSubStr(s1, s2, n - 1, m - 1, l + 1);

        // length for new sub-string including s1
        int lnIncludingS1 = lcSubStr(s1, s2, n, m - 1, 0);

        // length for new sub-string including s2
        int lnIncludingS2 = lcSubStr(s1, s2, n - 1, m, 0);

        return max(l, lnIncludingS1, lnIncludingS2);
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
        String s = "aaaabbaa";
        System.out.println(longestPalindromicSubstring(s, s.length())); // 6
    }
}
