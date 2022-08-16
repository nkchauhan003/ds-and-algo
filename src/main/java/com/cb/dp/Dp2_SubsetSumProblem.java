
package com.cb.dp;

/*
 * DP-Memoization
 * Time Complexity: sum*n
 * Space: sum*n + O(n) auxiliary stack space
 * */
public class Dp2_SubsetSumProblem {
    public static boolean isSubsetSum(int[] arr, int sum, int n, int table[][]) {

        // base case
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // check if already calculated
        if (table[sum][n] != -1)
            return table[sum][n] == 1 ? true : false;

        // if current element is greater than remaining sum
        if (arr[n - 1] > sum) {
            boolean flag = isSubsetSum(arr, sum, n - 1, table);
            // store in table before return
            table[sum][n] = flag ? 1 : 0;
            return flag;
        }

        // check if sum exists, when including or excluding current element
        boolean flag = isSubsetSum(arr, sum - arr[n - 1], n - 1, table) || isSubsetSum(arr, sum, n - 1, table);
        // store in table before return
        table[sum][n] = flag ? 1 : 0;
        return flag;
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;

        int table[][] = new int[sum + 1][n + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = -1;
        }

        System.out.println(isSubsetSum(set, sum, n, table)); // true

    }
}