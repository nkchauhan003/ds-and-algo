package com.cb.dp;

/*
 * Memoization
 * Binomial Coefficient (Mod "p")
 * Time Complexity: O(n*k)
 * */
public class Dp14_BinomialCoefficient {

    public static int c(int n, int k, int p, int t[][]) {
        if (n < k)
            return 0;
        if (k == 0 || k == n)
            return 1;

        if (t[n][k] != 0)
            return t[n][k];
        return t[n][k] = (c(n - 1, k - 1, p, t) % p + c(n - 1, k, p, t) % p) % p;
    }

    public static void main(String[] args) {
        int n = 50, k = 40;
        // 10^9 + 7
        int p = (int) (Math.pow((double) 10.0, (double) 9.0) + 7);
        int t[][] = new int[n + 1][k + 1];
        System.out.println(c(n, k, p, t)); // 272278100
    }
}
