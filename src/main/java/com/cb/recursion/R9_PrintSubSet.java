package com.cb.recursion;

import java.util.ArrayList;

/*
 * Recursion
 * */
public class R9_PrintSubSet {

    public static void printSubset(int arr[], int index, ArrayList<Integer> result) {

        if (index >= arr.length) {
            result.stream().forEach(System.out::print);
            System.out.println();
            return;
        }

        // don't take
        // Cloning 'result' is important
        printSubset(arr, index + 1, (ArrayList<Integer>) result.clone());

        // take
        result.add(arr[index]);
        printSubset(arr, index + 1, result);
    }

    public static void main(String[] args) {
        printSubset(new int[]{1, 2, 3}, 0, new ArrayList<>());
    }
}
