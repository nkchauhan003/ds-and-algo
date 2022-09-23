package com.cb.arrays;

/*
 * Buy and Sell Stock (One Transaction)
 * Time: O(n)
 * Space: O(1)
 * */
public class A15_BuyAndSellStock_OneTransaction_Recursion {
    public static int maxProfit(int prices[], int n, int maxPriceSoFar) {

        if (n < 1)
            return 0;

        return Math.max(
                maxPriceSoFar - prices[n - 1],
                maxProfit(prices, n - 1,
                        Math.max(maxPriceSoFar, prices[n - 1])));
    }


    public static void main(String[] args) {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices, prices.length, 0)); //655
    }
}
