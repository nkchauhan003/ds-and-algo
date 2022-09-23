package com.cb.arrays;

/*
 * Buy and Sell Stock (K Transaction)
 * Valley Peak Approach
 * Time: O(n)
 * Space: O(1)
 * */
public class A18_BuyAndSellStock_K_Transaction_Recursion_choice {
    public static int maxProfit(int arr[], int i, int n, boolean buy, int k) {

        if (i >= n || k < 1) return 0;

        if (buy) {
            return Math.max(-arr[i] + maxProfit(arr, i + 1, n, !buy, k), 0 + maxProfit(arr, i + 1, n, buy, k));
        } else {
            return Math.max(arr[i] + maxProfit(arr, i + 1, n, !buy, k - 1), 0 + maxProfit(arr, i + 1, n, buy, k));
        }
    }


    public static void main(String[] args) {
        int prices[] = {10, 22, 5, 75, 65, 80};
        int k = 2;
        System.out.println(maxProfit(prices, 0, prices.length, true, k)); //87
    }
}
