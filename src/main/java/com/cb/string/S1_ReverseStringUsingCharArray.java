package com.cb.string;

/*
 * Time: O(n)
 * Space: O(n)
 * */
public class S1_ReverseStringUsingCharArray {
    
    public static String reverse(String s, int n) {
        int i = 0, j = n - 1;
        char[] chars = s.toCharArray();
        while (j > i) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return chars.toString();
    }


    public static void main(String[] args) {
        String s = "amazing";
        System.out.println(reverse(s, s.length()));
    }
}
