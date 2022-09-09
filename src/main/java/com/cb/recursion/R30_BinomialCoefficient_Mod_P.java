package com.cb.recursion;

/*
 * Recursion
 * Binomial Coefficient (Mod "p")
 * Time Complexity: O(2^n)
 * */
public class R30_BinomialCoefficient_Mod_P {

    public static int c(int n, int k, int p) {
        if (n < k)
            return 0;
        if (k == 0 || k == n)
            return 1;
        return (c(n - 1, k - 1, p) % p + c(n - 1, k, p) % p) % p;
    }

    public static void main(String[] args) {
        int n = 50, k = 40;
        // 10^9 + 7
        int p = (int) (Math.pow((double) 10.0, (double) 9.0) + 7);
        System.out.println(c(n, k, p)); // 1682343578
    }
}
