package com.cb.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Alternating positive & negative items
 * Maintaining the order
 * Time: O(n*n)
 * Space: O(1)
 * */
public class A19_AlternatingPositiveNegative_np2_time_constantSpace {
    public static void rearrange(int arr[], int n) {

        int wrongIndex = -1;
        for (int i = 0; i < n; i++) {
            if (wrongIndex == -1) {
                // if odd index has -ve or even index has +ve
                if (i % 2 == 0 && arr[i] >= 0 || i % 2 == 1 && arr[i] < 0)
                    wrongIndex = i;
                // find next opposite sign to rotate/replace
            } else if (arr[wrongIndex] < 0 && arr[i] >= 0 || arr[wrongIndex] >= 0 && arr[i] < 0) {
                rotateByOne(arr, wrongIndex, i);

                // if one or more same sign wrong elements skipped
                if (i - wrongIndex > 2)
                    wrongIndex = wrongIndex + 2;
                else
                    wrongIndex = -1;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int n = arr.length;

        printArray(arr);
        rearrange(arr, n);
        printArray(arr); // -5,5,-2,2,-8,4,7,1,8,0
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    private static void rotateByOne(int[] arr, int i, int j) {
        int jthElement = arr[j];
        for (int k = j; k > i; k--)
            arr[k] = arr[k - 1];

        arr[i] = jthElement;
    }
}
