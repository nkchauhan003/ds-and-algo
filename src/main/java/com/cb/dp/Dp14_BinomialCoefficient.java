package com.cb.dp;

/*
 * DP
 * Binomial Coefficient
 * */
public class Dp14_BinomialCoefficient {
    public static int c(int n, int k) {
        if (n < k)
            return 0;
        int t[] = new int[n + 1];
        return fact(n, t) / (fact(k, t) * fact(n - k, t));
    }

    public static int fact(int n, int[] t) {
        if (n == 1)
            return 1;

        if (t[n] > 0)
            return t[n];

        return t[n] = n * fact(n - 1, t);

    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(c(n, k)); // 10
    }


}
