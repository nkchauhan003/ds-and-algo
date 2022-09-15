package com.cb.dp;

/*
 * Memoization
 * Palindrome Partitioning
 * Time Complexity: n^2
 * */
public class Dp20_PalindromePartitioning {

    public static int minPalindromePartition(String str, int s, int e, Integer[][] t) {

        if (t[s][e] != null)
            return t[s][e];

        if (s >= e || isPalindrome(str, s, e))
            return 0;

        int minCuts = Integer.MAX_VALUE;
        for (int k = s; k < e; k++) {
            int cuts = 1 + minPalindromePartition(str, s, k, t) + minPalindromePartition(str, k + 1, e, t);
            minCuts = minCuts < cuts ? minCuts : cuts;
        }
        return t[s][e] = minCuts;
    }

    // helper fn
    public static boolean isPalindrome(String str, int s, int e) {
        if (s >= e)
            return true;
        return str.charAt(s) == str.charAt(e) && isPalindrome(str, s + 1, e - 1);
    }

    // main
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        int n = s.length();

        Integer[][] t = new Integer[n + 1][n + 1];

        System.out.println(minPalindromePartition(s, 0, n - 1, t)); // 3
    }
}
