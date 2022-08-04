package com.cb.recursion;

/*
 * Input: 5
 * Output: 0,1,2,3,4,5
 * */
public class R2_PrintNumbers {
    public static void print(int n) {
        // base condition
        if (n < 0) return;
        
        // recursive call
        print(n - 1);

        // work
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(5);
    }
}
