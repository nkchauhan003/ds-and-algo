package com.cb.dp;

import java.math.BigInteger;

/*
 * Memoization
 * Nth Catalan Number
 * Time Complexity: O(n)
 * */
public class Dp15_Find_Nth_Catalan_Number {
    public static BigInteger nthCatalan(int n, BigInteger[] t) {
        if (n == 0 || n == 1)
            return BigInteger.valueOf(1);
        if (t[n] != null)
            return t[n];

        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++)
            result = result.add(nthCatalan(i, t).multiply(nthCatalan(n - i - 1, t)));

        return t[n] = result;
    }

    public static void main(String[] args) {
        int n = 10;
        BigInteger[] t = new BigInteger[n + 1];
        System.out.println(nthCatalan(n, t)); // 16796
    }
}
