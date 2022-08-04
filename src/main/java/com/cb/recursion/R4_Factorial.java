package com.cb.recursion;

/**
 * Tail Recursion
 */
public class R4_Factorial {

    public static long factorial(long n, long accumulator) {
        if (n == 1)
            return accumulator;
        return factorial(n - 1, n * accumulator);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5, 1));
        System.out.println(factorial(25, 1));
    }
}
