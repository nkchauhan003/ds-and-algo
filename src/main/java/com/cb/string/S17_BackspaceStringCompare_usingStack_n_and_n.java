package com.cb.string;

import java.util.Stack;

/*
 * Time complexity: O(n+m)
 * Space complexity: O(n+m)
 * */
public class S17_BackspaceStringCompare_usingStack_n_and_n {

    private static Stack<Character> finalCharStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }

    private static boolean backspaceCompare(String s, String t) {

        Stack<Character> st = finalCharStack(s);
        Stack<Character> tt = finalCharStack(t);

        if (st.size() != tt.size())
            return false;

        while (!st.isEmpty()) {
            if (st.pop() != tt.pop())
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abcd";
        String t = "bbcd";
        System.out.println(backspaceCompare(s, t));// true
    }
}
