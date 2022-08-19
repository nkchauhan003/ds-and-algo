package com.cb.recursion;

/*
 * Recursion
 * Rod Cutting Problem
 * Time Complexity: 2^n
 * */
public class R23_RodCuttingProblem {
    public static int profit(int[] pr, int ln, int n) {

        if (ln == 0 || n == 0)
            return 0;

        // n represents both 'index' and 'current piece length'
        // if remaining length is less than current piece length
        if (n > ln)
            return profit(pr, ln, n - 1);

        // if remaining length is greater or equal current piece length
        return max(pr[n - 1] + profit(pr, ln - n, n), profit(pr, ln, n - 1));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {

        // pieces length
        int[] pc = {1, 2, 3, 4, 5, 6, 7, 8};

        // pieces price
        int[] pr = {1, 5, 8, 9, 10, 17, 17, 20};

        // rod length
        int ln = 8;

        int n = pr.length;

        System.out.println(profit(pr, ln, n)); // 22
    }
}
