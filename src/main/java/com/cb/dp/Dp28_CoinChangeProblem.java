package com.cb.dp;

/*
 * Coin Change Problem
 * Time: O(n*n)
 * Space: O(n*n)
 * */
public class Dp28_CoinChangeProblem {
    public static long noOfWays(int coins[], int n, int sum, Long[][] t) {

        // 1 solution found
        // sum reduced to zero
        if (sum == 0)
            return 1;

        // n==0, all coins exhausted
        if (n == 0)
            return 0;
        
        if (t[n][sum] != null)
            return t[n][sum];

        // if current coin is greater than remaining sum
        if (coins[n - 1] > sum)
            return t[n][sum] = noOfWays(coins, n - 1, sum, t);

        // if selected, it can be selected again so n remains n
        // if not selected, next coin will be select next so n becomes n-1
        return t[n][sum] = noOfWays(coins, n, sum - coins[n - 1], t) + noOfWays(coins, n - 1, sum, t);
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5, 7};
        int n = coins.length;
        int sum = 8;

        Long[][] t = new Long[n + 1][sum + 1];
        System.out.println(noOfWays(coins, n, sum, t));
    }
}
