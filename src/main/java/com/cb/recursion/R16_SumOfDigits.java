package com.cb.recursion;

/*
* Recursion
* */
public class R16_SumOfDigits {
    public static int sum(int digits) {

        // all digits are exhausted or 0
        if (digits <= 0)
            return 0;

        // add current digit with sum(remainingDigits)
        return digits % 10 + sum(digits / 10);
    }

    public static void main(String[] args) {
        System.out.println(sum(1000));
        System.out.println(sum(1234));
        System.out.println(sum(0));
        System.out.println(sum(1));
    }
}
