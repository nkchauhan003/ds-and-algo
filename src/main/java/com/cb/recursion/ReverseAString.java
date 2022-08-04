package com.cb.recursion;

/*
 * Recursion
 * */
public class ReverseAString {

    // abc abcd
    public static String reverse(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return s;
        String s1 = swap(s, startIndex, endIndex);
        return reverse(s1, startIndex + 1, endIndex - 1);
    }

    private static String swap(String s, int i, int j) {

        char[] chars = s.toCharArray();

        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;

        return new String(chars);
    }

    public static void main(String[] args) {

        String s = "abc";
        System.out.println(reverse(s, 0, s.length() - 1));

        String s1 = "abcd";
        System.out.println(reverse(s1, 0, s1.length() - 1));
    }
}
