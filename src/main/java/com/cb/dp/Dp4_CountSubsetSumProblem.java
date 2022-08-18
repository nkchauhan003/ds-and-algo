package com.cb.dp;

/*
 * DP-Memoization
 * Time Complexity: sum*n
 * Space: sum*n + O(n) auxiliary stack space
 * */
public class Dp4_CountSubsetSumProblem {
    public static int countSubsetSum(int[] arr, int sum, int n, int table[][]) {

        // base case
        if (sum == 0) return 1;
        if (n == 0) return 0;

        // check if already calculated
        if (table[sum][n] != -1) return table[sum][n];

        // if current element is greater than remaining sum
        if (arr[n - 1] > sum)
            // store in table before return
            return table[sum][n] = countSubsetSum(arr, sum, n - 1, table);

        // check if sum exists, when including or excluding current element
        // store in table before return
        return table[sum][n] = countSubsetSum(arr, sum - arr[n - 1], n - 1, table) + countSubsetSum(arr, sum, n - 1, table);

    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;

        // initializing table with -1
        int table[][] = new int[sum + 1][n + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = -1;
        }
        System.out.println(countSubsetSum(set, sum, n, table)); // 2
    }
}