package com.cb.string;

import java.util.Set;

/*
 * Time complexity: O(n^n)
 * Space complexity: O(n)
 * */
public class S15_WorkBreak_recursive_map {

    private static int wordBreak(String s, String[] words) {
        if (s == null) return 0;
        return wbRecur(s, Set.of(words)) ? 1 : 0;
    }

    private static boolean wbRecur(String s, Set<String> words) {

        if (s.length() == 0) return true;
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            tmp += s.charAt(i);
            if (words.contains(tmp) && wbRecur(s.substring(i + 1), words))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ilike";
        String[] words = {"i", "like", "sam",
                "sung", "samsung", "mobile",
                "ice", "cream", "icecream",
                "man", "go", "mango"};
        System.out.println(wordBreak(s, words)); // true
    }
}
