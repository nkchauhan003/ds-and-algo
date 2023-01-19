package com.cb.recursion;

/*
 * Recursion + Swapping
 * */
public class R12_PermutationsOfString {

    // print only in last iteration
    public static void printPermutations(String s, int index) {
        if (index >= s.length() - 1) {
            System.out.println(s);
            return;
        }

        // swap with self and elements after current index
        for (int i = index; i < s.length(); i++) {
            printPermutations(swap(s, index, i), index + 1);
        }
    }

    private static String swap(String s, int i, int j) {

        char[] chars = s.toCharArray();

        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;

        return new String(chars);
    }

    public static void main(String[] args) {
        printPermutations("abc", 0);
    }
}
