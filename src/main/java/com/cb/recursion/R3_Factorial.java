package com.cb.recursion;

/**
 * Head Recursion
 */
public class R3_Factorial {

    public static long factorial(long n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(25));
    }
}
