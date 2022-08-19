package com.cb.dp;

/*
 * Memoization
 * Rod Cutting Problem
 * Time Complexity: n*ln
 * */
public class Dp6_RodCuttingProblem {
    public static int profit(int[] pr, int ln, int n, int[][] t) {

        if (ln == 0 || n == 0)
            return 0;

        if (t[ln][n] != -1)
            return t[ln][n];

        // n represents both 'index' and 'current piece length'
        // if remaining length is less than current piece length
        if (n > ln)
            return t[ln][n] = profit(pr, ln, n - 1, t);

        // if remaining length is greater or equal current piece length
        return t[ln][n] = max(pr[n - 1] + profit(pr, ln - n, n, t), profit(pr, ln, n - 1, t));
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

        int[][] t = new int[ln + 1][n + 1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }

        System.out.println(profit(pr, ln, n, t)); // 22
    }
}
