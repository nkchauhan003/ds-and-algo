package com.cb.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Maximum Product Sub-array
 * Time: O(min(n1,n2,n3))
 * Space: O(1)
 * */
public class A14_MinimumInThreeArrays_ThreePointers {
    public static List<Integer> printCommonElements(int a1[], int n1, int a2[], int n2, int a3[], int n3) {

        List<Integer> commonElements = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int lastCommon = Integer.MIN_VALUE;

        while (i < n1 && j < n2 && k < n3) {
            if (a1[i] == a2[j] && a1[i] == a3[k]) {
                if (lastCommon != a1[i])
                    commonElements.add(a1[i]);
                lastCommon = a1[i];
                i++;
                j++;
                k++;
            } else {
                int min = min(a1[i], a2[j], a3[k]);
                if (min == a1[i])
                    i++;
                if (min == a2[j])
                    j++;
                if (min == a3[k])
                    k++;
            }
        }
        return commonElements;
    }

    public static int min(int a, int b, int c) {
        return Math.min(c, Math.min(a, b));
    }


    public static void main(String[] args) {
        int a1[] = {1, 5, 10, 20, 40, 80};
        int a2[] = {6, 7, 20, 80, 100};
        int a3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(printCommonElements(a1, a1.length, a2, a2.length, a3, a3.length));
    }
}
