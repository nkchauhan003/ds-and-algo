package com.cb.dp;

/*
 * Memoization
 * S1 to S2 by Min Insert & Delete
 * Time Complexity: n*m
 * */
public class Dp11_ConvertStrAtoBbyMinInsertAndDelete {

    // ind -> insert+delete
    public static int minInsDel(String s1, String s2, int n, int m, Integer t[][]) {

        if (n == 0) return m;

        if (m == 0) return n;

        if (t[n][m] != null)
            return t[n][m];

        // matching character
        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return t[n][m] = minInsDel(
                    s1.substring(0, n - 1), s2.substring(0, m - 1), n - 1, m - 1, t);

        // check between add/delete
        return t[n][m] = min(
                1 + minInsDel(s1 + s2.charAt(m - 1), s2, n + 1, m, t),
                1 + minInsDel(s1.substring(0, n - 1), s2, n - 1, m, t));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {

        String s1 = "heap";
        String s2 = "pea";
        int n = s1.length();
        int m = s2.length();

        Integer t[][] = new Integer[n + m + 1][m + 1];
        System.out.println(minInsDel(s1, s2, n, m, t)); //4
    }
}
