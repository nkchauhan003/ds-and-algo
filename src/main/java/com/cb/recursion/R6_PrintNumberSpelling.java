package com.cb.recursion;

/**
 * Recursion
 */
public class R6_PrintNumberSpelling {

    static String[] mappingArray = {"Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"};

    public static String printSpelling(int n) {
        if (n < 1)
            return "";

        int current = n % 10;
        int remaining = n / 10;

        return printSpelling(remaining) + " " + mappingArray[current];
    }

    public static void main(String[] args) {
        System.out.println(printSpelling(1000));
        System.out.println(printSpelling(1));
        System.out.println(printSpelling(126));
        System.out.println(printSpelling(895));
    }
}
