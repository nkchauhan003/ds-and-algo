package com.cb.recursion;

import java.util.ArrayList;

/*
 * Recursion
 * */
public class R9_PrintSubSet {

    public static void printSubset(int arr[], int index, ArrayList<Integer> currentSubset) {

        // print only in last iteration
        if (index >= arr.length) {
            System.out.println(currentSubset);
            return;
        }

        // don't take
        // Cloning 'result' is important
        printSubset(arr, index + 1, (ArrayList<Integer>) currentSubset.clone());

        // take
        currentSubset.add(arr[index]);
        printSubset(arr, index + 1, currentSubset);
    }

    public static void main(String[] args) {
        printSubset(new int[]{1, 2, 3}, 0, new ArrayList<>());
    }
}
