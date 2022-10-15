package com.cb.string;

/*
 * Time complexity: O(n)
 * */
public class S5_ReverseWordsInAString {

    private static String reverseWords(String s, int n) {
        // reverse entire string
        s = reverse(s, 0, n - 1);

        // reverse individual words
        int st = 0, en;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i+1) == ' ') {
                en = i;
                s = reverse(s, st, en);
                st = i + 2;
            }
        }
        return s;
    }

    public static String reverse(String s, int st, int en) {
        char[] chars = s.toCharArray();
        while (en > st) {
            char c = chars[st];
            chars[st] = chars[en];
            chars[en] = c;
            st++;
            en--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "The purpose of our lives is to be happy";
        System.out.println(reverseWords(s, s.length())); // program amazing an is this
    }
}
