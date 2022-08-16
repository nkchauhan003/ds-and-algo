package com.cb.recursion;

/*
 * Recursion
 * Subset Sum
 * Time Complexity: 2^n
 * */
public class R19_SubsetSumProblem {
    public static boolean isSubsetSum(int[] arr, int sum, int n) {

        // base case
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // if current element is greater than remaining sum
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, sum, n - 1);

        // check if sum exists, when including or excluding current element
        return isSubsetSum(arr, sum - arr[n - 1], n - 1) || isSubsetSum(arr, sum, n - 1);
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        System.out.println(isSubsetSum(set, sum, n)); // true

        int[] set1 = {3, 34, 4, 12, 5, 2};
        int sum1 = 30;
        int n1 = set.length;
        System.out.println(isSubsetSum(set1, sum1, n1)); // false
    }
}


