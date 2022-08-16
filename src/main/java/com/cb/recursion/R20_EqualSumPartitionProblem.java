package com.cb.recursion;

/*
 * Recursion
 * Equal Sum Partition
 * Time Complexity: 2^n
 * */
public class R20_EqualSumPartitionProblem {
    public static boolean isEqualSumPartition(int[] arr, int n) {

        // calculate sum of array
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        // odd sum can not be divided in two
        if (sum % 2 != 0)
            return false;


        // check of sub-array with "sum / 2" sum is present
        return isSubsetSum(arr, sum / 2, n);
    }

    public static boolean isSubsetSum(int[] arr, int sum, int n) {

        // base case
        if (sum == 0)
            return false;
        if (n == 0)
            return true;

        // if current element is greater than remaining sum
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, sum, n - 1);

        // check if sum exists, when including or excluding current element
        return isSubsetSum(arr, sum - arr[n - 1], n - 1) || isSubsetSum(arr, sum, n - 1);
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


