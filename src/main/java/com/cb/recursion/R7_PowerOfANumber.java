package com.cb.recursion;

public class R7_PowerOfANumber {
    public static int pow(int n, int p) {
        if (p == 0)
            return 1;
        return n * pow(n, p - 1);
    }

    public static void main(String[] args) {
        System.out.println(pow(2,8));
        System.out.println(pow(4,3));
    }
}
