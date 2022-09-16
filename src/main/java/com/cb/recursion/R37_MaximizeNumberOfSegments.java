package com.cb.recursion;

/*
 * Recursion
 * Maximize number of segments
 * Time Complexity: 2^n
 * */
public class R37_MaximizeNumberOfSegments {


    public static int segments(int l, int p, int q, int r) {

        // rod is exhausted
        if (l == 0)
            return 0;

        // invalid combination
        if (l < 0)
            return -Integer.MAX_VALUE;

        // cutting segment of size p
        int a = 1 + segments(l - p, p, q, r);

        // cutting segment of size p
        int b = 1 + segments(l - q, p, q, r);

        // cutting segment of size p
        int c = 1 + segments(l - r, p, q, r);

        return max(a, b, c);
    }

    public static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        if (b >= a && b >= c)
            return b;
        return c;
    }

    // main
    public static void main(String[] args) {
        System.out.println(segments(7, 2, 5, 5)); // 3
    }
}
