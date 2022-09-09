package com.cb.recursion;

/*
 * Recursion
 * Binomial Coefficient
 * */
public class R30_BinomialCoefficient {
    public static int c(int n, int k) {
        if (n < k)
            return 0;
        return fact(n) / (fact(k) * fact(n - k));
    }

    public static int fact(int n) {
        if (n == 1)
            return 1;
        return n * fact(n - 1);

    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(c(n, k)); // 10
    }


}
