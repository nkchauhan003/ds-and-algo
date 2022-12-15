package com.cb.arrays;

/*
 * Time: O(n * length of prefix)
 * Space: O(1)
 * */
public class A27_LongestCommonPrefix {

    private static String longestCommonPrefix(String arr[], int n) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i].length() < minLength)
                minLength = arr[i].length();

        Character c = null;
        int last = 0;
        while (last < minLength) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    c = arr[j].charAt(last);
                else if (arr[j].charAt(last) != c)
                    return last == 0 ? "-1" : arr[0].substring(0, last);
            }
            last++;
        }
        return last == 0 ? "- 1" : arr[0].substring(0, last);
    }

    public static void main(String[] args) {
        String arr[] = {"cup", "cupboard", "cut", "curse"};
        System.out.println(longestCommonPrefix(arr, arr.length)); // "2"
    }
}
