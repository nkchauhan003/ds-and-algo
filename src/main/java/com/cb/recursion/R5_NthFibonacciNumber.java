package com.cb.recursion;

/*
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
 * */
public class R5_NthFibonacciNumber {

    public static int nthFibonacciNumber(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        return nthFibonacciNumber(n - 1) + nthFibonacciNumber(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(1));
        System.out.println(nthFibonacciNumber(2));
        System.out.println(nthFibonacciNumber(3));
        System.out.println(nthFibonacciNumber(8));
    }
}
