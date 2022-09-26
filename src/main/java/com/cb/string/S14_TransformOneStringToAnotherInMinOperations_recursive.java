package com.cb.string;

/*
 * Time complexity: O(n)
 * */
public class S14_TransformOneStringToAnotherInMinOperations_recursive {

    private static int minOpRequired(String s1, int n1, String s2, int n2) {

        if (!isTransformationPossible(s1, n1, s2, n2))
            return -1;

        return minOp(s1, s2, s1.length(), s2.length());
    }

    private static int minOp(String s1, String s2, int n1, int n2) {

        if (n1 == 0)
            return 0;

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            return minOp(s1, s2, n1 - 1, n2 - 1);
        else
            return 1 + minOp(s1, s2, n1 - 1, n2);
    }

    private static boolean isTransformationPossible(String s1, int n1, String s2, int n2) {
        if (n1 != n2)
            return false;

        int[] ascii = new int[256];

        for (int i = 0; i < n1; i++) {
            ascii[s1.charAt(i)] = ascii[s1.charAt(i)] + 1;
            ascii[s2.charAt(i)] = ascii[s2.charAt(i)] - 1;
        }

        for (int i = 0; i < n1; i++) {
            if (ascii[s1.charAt(i)] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "EACBD";
        String s2 = "EABCD";
        System.out.println(minOpRequired(s1, s1.length(), s2, s2.length())); // 3
    }
}
