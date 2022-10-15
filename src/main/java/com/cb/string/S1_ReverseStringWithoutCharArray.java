package com.cb.string;

/*
 * Time: O(n)
 * Space: O(n)
 * */
public class S1_ReverseStringWithoutCharArray {

    public static String reverse(String s, int n) {
        String reversed = "";
        for (int i = 0; i < n; i++) {
            reversed = s.charAt(i) + reversed;
        }
        return reversed;
    }


    public static void main(String[] args) {
        String s = "amazing";
        System.out.println(reverse(s, s.length()));
    }
}
