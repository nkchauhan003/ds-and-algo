package com.cb.recursion;

/*
 * Recursion
 * S1 to S2 by Min Insert & Delete
 * Time Complexity: n^2
 * */
public class R28_ConvertStrAtoBbyMinInsertAndDelete {

    // ind -> insert+delete
    public static int minInsDel(String s1, String s2, int n, int m) {

        if (n == 0) return m;

        if (m == 0) return n;

        // matching character
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) return minInsDel(
                s1.substring(0, n - 1), s2.substring(0, m - 1), n - 1, m - 1);

        // check between add/delete
        return min(
                1 + minInsDel(s1 + s2.charAt(m - 1), s2, n + 1, m),
                1 + minInsDel(s1.substring(0, n - 1), s2, n - 1, m));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "gzbcf";
        int n = s1.length();
        int m = s2.length();

        System.out.println(minInsDel(s1, s2, n, m)); //4
    }
}
