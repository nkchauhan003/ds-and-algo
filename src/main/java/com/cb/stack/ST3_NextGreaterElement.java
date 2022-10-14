package com.cb.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ST3_NextGreaterElement {

    public static int[] nextGreater(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.empty() && stack.peek() <= arr[i])
                stack.pop();

            if (!stack.empty())
                nge[i] = stack.peek();
            else
                nge[i] = -1;
            stack.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25, 10};
        int nge[] = nextGreater(arr, arr.length);
        printArray(nge); // 5,25,25,-1,-1
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
}
