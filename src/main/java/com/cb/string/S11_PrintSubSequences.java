package com.cb.string;

/*
 * All subsequences of a string
 * Time complexity: O(2^n)
 * Recursion
 * */
public class S11_PrintSubSequences {

    private static void subsequence(String s, int n, String ss) {

        // if string is exhausted
        if (n == 0) {

            // don't print blank
            if (!ss.isBlank())
                System.out.print(ss + ",");
            return;
        }

        // including current character
        subsequence(s, n - 1, s.charAt(n - 1) + ss);

        // excluding current character
        subsequence(s, n - 1, ss);
    }

    public static void main(String[] args) {
        String s = "abc";
        subsequence(s, s.length(), ""); // abc,bc,ac,c,ab,b,a
    }
}
