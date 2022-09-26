package com.cb.dp;

/*
 * Word Wrap
 * Time: O(n*k)
 * Space: O(n*k)
 * */
public class Dp29_WordWrap {
    public static int minCost(int words[], int n, int i, int k, int currK, Integer t[][]) {

        if (i == n)
            return 0;

        if (t[i][currK] != null)
            return t[i][currK];

        // first word of a line don't need white space
        int spaceNeeded = currK < k ? words[i] + 1 : words[i];

        if (spaceNeeded > currK)
            return t[i][currK] = (currK * currK) + minCost(words, n, i + 1, k, k - words[i], t);

        return t[i][currK] = Math.min(
                minCost(words, n, i + 1, k, currK - spaceNeeded, t),
                currK * currK + minCost(words, n, i + 1, k, k - words[i], t));
    }


    public static void main(String[] args) {
        int[] words = {3, 2, 2, 5};
        int k = 6;
        int n = words.length;

        Integer t[][] = new Integer[n + 1][k + 1];
        System.out.println(minCost(words, n, 0, k, k, t));
    }
}
