package com.cb.dp;

/*
 * Buy and Sell Stock (Unlimited Transaction)
 * Time: O(n)
 * Space: O(1)
 * */
public class Dp26_BuyAndSellStock_K_Transaction {
    public static int maxProfit(int arr[], int i, int n, boolean buy, int k, Integer t[][][]) {

        if (i == n || k == 0) return 0;
        if (t[i][buy ? 1 : 0][k] != null) return t[i][buy ? 1 : 0][k];

        if (buy) {
            return t[i][buy ? 1 : 0][k] = Math.max(
                    -arr[i] + maxProfit(arr, i + 1, n, !buy, k, t), 0 + maxProfit(arr, i + 1, n, buy, k, t));
        } else {
            return t[i][buy ? 1 : 0][k] = Math.max(
                    arr[i] + maxProfit(arr, i + 1, n, !buy, k - 1, t), 0 + maxProfit(arr, i + 1, n, buy, k, t));
        }
    }

    public static void main(String[] args) {
        int prices[] = {10, 22, 5, 75, 65, 80};
        int n = prices.length;
        int k = 2;

        Integer t[][][] = new Integer[n + 1][2][k + 1];
        System.out.println(maxProfit(prices, 0, prices.length, true, k, t)); //865
    }
}
