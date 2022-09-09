package com.cb.recursion;

/*
 * Nth Catalan Number
 * Time Complexity: O(2^n)
 * */
public class R31_Find_Nth_Catalan_Number {
    public static int nthCatalan(int n) {
        if (n == 0 || n == 1)
            return 1;

        int result = 0;
        for (int i = 0; i < n; i++)
            result += (nthCatalan(i) * nthCatalan(n - i - 1));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(nthCatalan(5));
    }
}
