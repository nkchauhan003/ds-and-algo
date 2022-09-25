package com.cb.arrays;

/*
 * Choose and Swap
 * Time: O(n^2)
 * Space: O(1)
 * */
public class A20_ChooseAndSwap_np2_time_constantSpace {
    public static void rearrange(char[] s, int n) {

        Character c1 = null, c2 = null;
        for (int i = 0; i < n - 1; i++) {
            char c = s[i];
            int j = i + 1;
            while (j < n) {
                if (s[j] < c && (c2 == null || s[j] < c2)) {
                    int k = i - 1;
                    boolean isGood = true;
                    while (k >= 0) {
                        if (s[k] == s[j]) {
                            isGood = false;
                            break;
                        }
                        k--;
                    }
                    if (isGood) {
                        c1 = s[i];
                        c2 = s[j];
                    }
                }
                j++;
            }
            if (c1 != null)
                break;
        }
        if (c1 != null)
            for (int i = 0; i < n; i++) {
                if (s[i] == c1)
                    s[i] = c2;
                else if (s[i] == c2)
                    s[i] = c1;
            }
    }


    public static void main(String[] args) {
        String s = "baab";
        int n = s.length();

        char[] chars = s.toCharArray();
        System.out.println(chars);
        rearrange(chars, n);
        System.out.println(chars);

    }
}
