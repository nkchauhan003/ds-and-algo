package com.cb.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Print all Permutations
 * Time: O(n * !n)
 * Space: O(2 n^) ~ O(n^)
 * */
public class A21_PrintAllPermutations_extraSpace_ArrayList {
    public static void permutationsRecur(
            int[] arr, int n, boolean[] taken, List<Integer> perm, List<List<Integer>> ans) {

        if (perm.size() == n)
            ans.add(perm);

        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                boolean[] t = Arrays.copyOf(taken, n);
                t[i] = true;

                List<Integer> p = new ArrayList<>(perm);
                p.add(arr[i]);

                permutationsRecur(arr, n, t, p, ans);
            }
        }
    }

    public static List<List<Integer>> permutations(int[] arr) {
        int n = arr.length;
        List<List<Integer>> permutations = new ArrayList<>();
        permutationsRecur(arr, n, new boolean[n], new ArrayList<>(), permutations);
        return permutations;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1};
        System.out.println(permutations(arr));
    }
}
