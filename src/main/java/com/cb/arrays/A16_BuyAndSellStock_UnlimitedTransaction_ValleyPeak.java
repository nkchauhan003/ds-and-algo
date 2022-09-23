package com.cb.arrays;

/*
 * Buy and Sell Stock (Unlimited Transaction)
 * Valley Peak Approach
 * Time: O(n)
 * Space: O(1)
 * */
public class A16_BuyAndSellStock_UnlimitedTransaction_ValleyPeak {
    public static int maxProfit(int prices[], int n) {

        int profit = 0;

        for (int i = 1; i < n; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];

        return profit;
    }


    public static void main(String[] args) {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices, prices.length)); //865
    }
}
