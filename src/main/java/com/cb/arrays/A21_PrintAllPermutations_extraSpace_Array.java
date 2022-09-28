package com.cb.arrays;

import java.util.Arrays;

/*
 * Print all Permutations
 * Time: O(n * !n)
 * Space: O(2 n^) ~ O(n^)
 * */
public class A21_PrintAllPermutations_extraSpace_Array {
    public static void print(char[] arr, int n, char[] t, char[] p) {

        if (isFull(p))
            System.out.println(p);

        for (int i = 0; i < n; i++) {
            if (t[i] == '\u0000') {
                char nt[] = Arrays.copyOf(t,n);
                nt[i] = arr[i];

                char np[] = Arrays.copyOf(p,n);
                appendFirstEmpty(np, arr[i]);

                print(arr, n, nt, np);
            }
        }
    }

    public static boolean isFull(char[] chars) {
        for (int i = 0; i < chars.length; i++)
            if (chars[i] == '\u0000') return false;
        return true;
    }

    public static void appendFirstEmpty(char[] chars, char c) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\u0000') {
                chars[i] = c;
                break;
            }
        }
    }

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c'};
        int n = arr.length;
        print(arr, n, new char[n], new char[n]);
    }
}
