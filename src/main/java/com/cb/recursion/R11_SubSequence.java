package com.cb.recursion;

public class R11_SubSequence {

    public static void printSubSequence(String s, int index, String subString) {
        if (index >= s.length()) {
            System.out.println(subString);
            return;
        }

        // not taking current character
        printSubSequence(s, index + 1, subString);

        // taking current character
        subString += s.charAt(index);
        printSubSequence(s, index + 1, subString);
    }

    public static void main(String[] args) {
        printSubSequence("abc", 0, "");
    }
}
