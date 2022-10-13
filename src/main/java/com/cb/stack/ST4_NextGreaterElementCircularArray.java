package com.cb.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ST4_NextGreaterElementCircularArray {

    public static int[] nextGreater(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stack.empty() && stack.peek() <= arr[i % n])
                stack.pop();

            if (!stack.empty())
                nge[i % n] = stack.peek();
            else
                nge[i % n] = -1;
            stack.push(arr[i % n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int arr[] = {5, 7, 1, 2, 6, 0};
        int nge[] = nextGreater(arr, arr.length);
        printArray(nge);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
