package com.cb.dp;

public class DP23_MinimumNumberOfJumps {

    public static int minJump(int arr[], int n, int i, Integer t[]) {

        if (i >= n - 1)
            return 0;

        int maxJumps = arr[i];

        if (maxJumps == 0)
            return Integer.MAX_VALUE;

        if (t[i] != null)
            return t[i];

        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + maxJumps; j++) {
            int jumps = minJump(arr, n, j, t);

            // +1 is for current jump and check for handling overflow
            if (jumps != Integer.MAX_VALUE)
                jumps = jumps + 1;

            min = Math.min(jumps, min);
        }

        return t[i] = min;
    }

    public static int minJumpCheckUnreachable(int arr[], int n, int i, Integer t[]) {
        int jump = minJump(arr, n, i, t);
        return jump == Integer.MAX_VALUE ? -1 : jump;
    }


    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int n = arr.length;
        Integer t[] = new Integer[n + 1];
        System.out.println(minJumpCheckUnreachable(arr, n, 0, t));
    }
}


