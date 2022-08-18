package com.cb.dp;

/*
 * Memoization
 * Equal Sum Partition
 * Time Complexity: n * sum
 * */
public class Dp3_EqualSumPartitionProblem {
    public static boolean isEqualSumPartition(int[] arr, int n) {

        // calculate sum of array
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        // odd sum can not be divided in two
        if (sum % 2 != 0)
            return false;

        // initializing table with -1
        int table[][] = new int[sum + 1][n + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = -1;
        }


        // check of sub-array with "sum / 2" sum is present
        return isSubsetSum(arr, sum / 2, n, table);
    }

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
        int[] set = {1, 5, 11, 5};
        int n = set.length;
        System.out.println(isEqualSumPartition(set, n)); // true

        int[] set1 = {1, 5, 3};
        int n1 = set.length;
        System.out.println(isEqualSumPartition(set1, n1)); // false
    }
}
