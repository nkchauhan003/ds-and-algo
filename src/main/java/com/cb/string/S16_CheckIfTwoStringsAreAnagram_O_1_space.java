package com.cb.string;

import java.util.Arrays;

/*
 * Time complexity: O(n log n)
 * Space complexity: O(1)
 * */
public class S16_CheckIfTwoStringsAreAnagram_O_1_space {

    private static boolean isAnagram(String s1, String s2, int n, int m) {

        if (n != m)
            return false;

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        // O(n long n)
        Arrays.sort(ch1);

        // O(n long n)
        Arrays.sort(ch2);

        for (int i = 0; i < n; i++) {
            if (ch1[i] != ch2[i])
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        String s1 = "act";
        String s2 = "cat";
        System.out.println(isAnagram(s1, s2, s1.length(), s2.length()));// true
    }
}
