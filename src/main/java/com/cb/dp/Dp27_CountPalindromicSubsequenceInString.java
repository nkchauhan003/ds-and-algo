package com.cb.dp;

/*
 * Count All Palindromic Subsequence
 * Time: O(n*n)
 * Space: O(n*n)
 * */
public class Dp27_CountPalindromicSubsequenceInString {
    public static int count(String s, int i, int j, Integer t[][]) {

        if (i > j)
            return 0;

        if (i == j)
            return 1;

        if (t[i][j] != null)
            return t[i][j];
        if (s.charAt(i) == s.charAt(j))
            return t[i][j] = count(s, i + 1, j, t) + count(s, i, j - 1, t) + 1;
        else
            return t[i][j] = count(s, i + 1, j, t) + count(s, i, j - 1, t) - count(s, i + 1, j - 1, t);
    }

    public static void main(String[] args) {
        String s = "abcd";
        int n = s.length();
        Integer t[][] = new Integer[n + 1][n + 1];
        System.out.println(count(s, 0, n - 1, t));
    }
}
