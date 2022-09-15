package com.cb.recursion;

/*
 * Recursion
 * Palindrome Partitioning
 * Time Complexity: 2^n
 * */
public class R35_PalindromePartitioning {

    public static int minPalindromePartition(String str, int s, int e) {
        if (s >= e || isPalindrome(str, s, e)) return 0;

        int minCuts = Integer.MAX_VALUE;
        for (int k = s; k < e; k++) {
            int cuts = 1 + minPalindromePartition(str, s, k) + minPalindromePartition(str, k + 1, e);
            minCuts = minCuts < cuts ? minCuts : cuts;
        }
        return minCuts;
    }

    // helper fn
    public static boolean isPalindrome(String str, int s, int e) {
        if (s >= e) return true;
        return str.charAt(s) == str.charAt(e) && isPalindrome(str, s + 1, e - 1);
    }

    // main
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(minPalindromePartition(s, 0, s.length() - 1)); // 3
    }
}
