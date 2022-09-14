package com.cb.recursion;

/*
 * Recursion
 * Friends Pairing Problem
 * Time Complexity: Exponential O(2^n)
 * */
public class R33_FriendsPairingProblem {
    public static int noOfWays(int n) {
        if (n <= 2)
            return n;
        return noOfWays(n - 1) + (n - 1) * noOfWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(noOfWays(n)); //10
    }
}
