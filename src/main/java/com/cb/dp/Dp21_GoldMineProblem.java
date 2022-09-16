package com.cb.dp;

/*
 * Memoization
 * Gold Mine Problem
 * Time Complexity: O(n*m)
 * */
public class Dp21_GoldMineProblem {

    // it decides which row to start from in first column
    public static int maxGold(int arr[][], int n, int m) {

        int maxGold = 0;

        Integer[][] t = new Integer[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            int max = maxGoldInPath(arr, n, m, i, 0, t);
            maxGold = Math.max(maxGold, max);
        }

        return maxGold;
    }

    // decide path having max gold
    public static int maxGoldInPath(int arr[][], int n, int m, int i, int j, Integer[][] t) {

        if (i == n || j == m || i < 0)
            return 0;

        if (t[i][j] != null)
            return t[i][j];

        // top-right
        int tr = maxGoldInPath(arr, n, m, i - 1, j + 1, t);

        // right
        int r = maxGoldInPath(arr, n, m, i, j + 1, t);

        // bottom-right
        int br = maxGoldInPath(arr, n, m, i + 1, j + 1, t);

        return t[i][j] = arr[i][j] + max(tr, r, br);
    }

    public static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        if (b >= a && b >= c)
            return b;
        return c;
    }


    // main
    public static void main(String[] args) {
        int arr[][] = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4},
        };
        int n = 3, m = 3;
        System.out.println(maxGold(arr, n, m)); // 12
    }
}
