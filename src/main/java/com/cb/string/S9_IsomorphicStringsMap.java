package com.cb.string;

import java.util.HashMap;

/*
 * Isomorphic String
 * Time: O(n+m)
 * Space: O(distinctCharacters([n,m]))
 * */
public class S9_IsomorphicStringsMap {

    private static boolean isomorphic(String s1, String s2, int n, int m) {
        if (n != m)
            return false;

        HashMap<Character, Character> characters = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // character is s1 should map same character in s2
            if (characters.containsKey(c1)) {
                char tmp = characters.get(c1);
                if (tmp != c2)
                    return false;
                // any character in s2 should not map with two different characters in s1
            } else if (characters.containsValue(c2))
                return false;
            else
                characters.put(c1, c2);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "zoo";
        String s2 = "aas";
        System.out.println(isomorphic(s1, s2, s1.length(), s2.length())); // false

        s1 = "wfca";
        s2 = "yssy";
        System.out.println(isomorphic(s1, s2, s1.length(), s2.length())); // false

        s1 = "zhi";
        s2 = "kcz";
        System.out.println(isomorphic(s1, s2, s1.length(), s2.length())); // true
    }
}
