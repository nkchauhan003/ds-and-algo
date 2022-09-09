package com.cb.recursion;

/*
 * Recursion
 * Binomial Coefficient
 * Time Complexity: O(2^n)
 * */
public class R30_BinomialCoefficient {
    public static int c(int n, int k) {
        if (n < k)
            return 0;
        if (n == k || k == 0)
            return 1;
        return c(n - 1, k - 1) + c(n - 1, k);
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(c(n, k)); // 10
    }
}
