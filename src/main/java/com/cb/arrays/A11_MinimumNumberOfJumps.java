package com.cb.arrays;

public class A11_MinimumNumberOfJumps {

    public static int minJump(int arr[], int n, int i) {

        if (i >= n - 1)
            return 0;

        int maxJumps = arr[i];

        if (maxJumps == 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + maxJumps; j++) {
            int jumps = minJump(arr, n, j);

            // +1 is for current jump and check for handling overflow
            if (jumps != Integer.MAX_VALUE)
                jumps = jumps + 1;

            min = Math.min(jumps, min);
        }

        return min;
    }


    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(minJump(arr, arr.length, 0));
    }
}


