package com.cb.arrays;

/*
 * Buy and Sell Stock (Unlimited Transaction)
 * Valley Peak Approach
 * Time: O(n)
 * Space: O(1)
 * */
public class A17_BuyAndSellStock_UnlimitedTransaction_Recursion_choice {
    public static int maxProfit(int arr[], int i, int n, boolean buy) {
        if (i >= n) return 0;

        if (buy) {
            return Math.max(-arr[i] + maxProfit(arr, i + 1, n, !buy), 0 + maxProfit(arr, i + 1, n, buy));
        } else {
            return Math.max(arr[i] + maxProfit(arr, i + 1, n, !buy), 0 + maxProfit(arr, i + 1, n, buy));
        }
    }


    public static void main(String[] args) {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices, 0, prices.length, true)); //865
    }
}
