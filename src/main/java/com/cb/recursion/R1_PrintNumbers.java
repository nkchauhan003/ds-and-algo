package com.cb.recursion;

/*
 * Input: 5
 * Output: 5,4,3,2,1,0
 * */
public class R1_PrintNumbers {

    public static void print(int n) {
        // base condition
        if (n < 0) return;

        // work
        System.out.println(n);

        // recursive call
        print(n - 1);
    }

    public static void main(String[] args) {
        print(5);
    }
}
