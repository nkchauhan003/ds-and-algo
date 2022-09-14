package com.cb.dp;

/*
 * Memoization
 * Friends Pairing Problem
 * Time Complexity: O(n)
 * */
public class Dp17_FriendsPairingProblem {

    // just to fit very large answer
    static int p = (int) (Math.pow((double) 10.0, (double) 9.0) + 7);

    public static long noOfWays(int n, long[] t) {
        if (n <= 2)
            return n;
        if (t[n] != 0)
            return t[n];
        return t[n] = (noOfWays(n - 1, t) + ((n - 1) * noOfWays(n - 2, t))) % p;
    }

    public static void main(String[] args) {
        int n = 4;
        long t[] = new long[n + 1];
        System.out.println(noOfWays(n, t)); //10
    }
}
