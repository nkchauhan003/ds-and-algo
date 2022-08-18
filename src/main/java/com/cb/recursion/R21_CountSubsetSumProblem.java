package com.cb.recursion;

/*
 * Recursion
 * Count Subset Sum
 * Time Complexity: 2^n
 * */
public class R21_CountSubsetSumProblem {
    public static int countSubsetSum(int[] arr, int sum, int n) {

        // base case
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        // if current element is greater than remaining sum
        if (arr[n - 1] > sum)
            return countSubsetSum(arr, sum, n - 1);

        // check if sum exists, when including or excluding current element
        return countSubsetSum(arr, sum - arr[n - 1], n - 1) + countSubsetSum(arr, sum, n - 1);
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3, 3, 6};
        int sum = 6;
        int n = set.length;
        System.out.println(countSubsetSum(set, sum, n)); // 4

        int[] set1 = {1, 1, 1, 4};
        int sum1 = 1;
        int n1 = set1.length;
        System.out.println(countSubsetSum(set1, sum1, n1)); // 3
    }
}


