package com.cb.arrays;

/*
 * Buy and Sell Stock (One Transaction)
 * Time: O(n)
 * Space: O(1)
 * */
public class A15_BuyAndSellStock_OneTransaction_Iterative {
    public static int maxProfit(int price[], int n) {

        int minSoFar = price[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, price[i] - minSoFar);
            minSoFar = Math.min(minSoFar, price[i]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int price[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(price, price.length)); //5
    }
}
