package com.cb.recursion;

/*
 * Recursion
 * */
public class R15_CheckForPalindromeString {

    public static boolean isPalindrome(String s, int startIndex, int endIndex) {

        // single character string is a palindrome
        if (startIndex >= endIndex) {
            return true;
        }

        // palindrome should have same start & end element
        if (s.charAt(startIndex) != s.charAt(endIndex))
            return false;

        // it checks if middle substring is also palindrome
        return isPalindrome(s, startIndex + 1, endIndex - 1);
    }

    public static void main(String[] args) {
        String s1 = "a";
        System.out.println(isPalindrome(s1, 0, s1.length() - 1));

        String s2 = "ab";
        System.out.println(isPalindrome(s2, 0, s2.length() - 1));

        String s3 = "xyz";
        System.out.println(isPalindrome(s3, 0, s3.length() - 1));

        String s4 = "aba";
        System.out.println(isPalindrome(s4, 0, s1.length() - 1));

        String s5 = "abcdcba";
        System.out.println(isPalindrome(s5, 0, s5.length() - 1));
    }
}
