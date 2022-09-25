package com.cb.dp;

/*
 * Buy and Sell Stock (Unlimited Transaction)
 * Time: O(n)
 * Space: O(1)
 * */
public class Dp25_BuyAndSellStock_UnlimitedTransaction {
    public static int maxProfit(int arr[], int i, int n, boolean buy, Integer t[][]) {

        if (i >= n) return 0;

        if (t[i][buy ? 1 : 0] != null)
            return t[i][buy ? 1 : 0];

        if (buy) {
            return t[i][buy ? 1 : 0] = Math.max(
                    -arr[i] + maxProfit(arr, i + 1, n, !buy, t), 0 + maxProfit(arr, i + 1, n, buy, t));
        } else {
            return t[i][buy ? 1 : 0] = Math.max(
                    arr[i] + maxProfit(arr, i + 1, n, !buy, t), 0 + maxProfit(arr, i + 1, n, buy, t));
        }
    }


    public static void main(String[] args) {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int n = prices.length;

        Integer t[][] = new Integer[n + 1][2];
        System.out.println(maxProfit(prices, 0, prices.length, true, t)); //865
    }
}
