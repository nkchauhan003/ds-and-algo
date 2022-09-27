package com.cb.dp;

/*
 * Edit Distance
 * Time: O(n1*n2)
 * Space: O(n1*n2)
 * */
public class Dp30_EditDistanceProblem {
    public static int minOps(String s1, int n1, String s2, int n2, Integer[][] t) {

        if (n1 == 0) return n2;

        if (n2 == 0) return n1;

        if (t[n1][n2] != null)
            return t[n1][n2];

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            return t[n1][n2] = minOps(s1, n1 - 1, s2, n2 - 1, t);

        // add to s1's substring and do +1 to size
        int byAdding = minOps(s1.substring(0, n1) + s2.charAt(n2 - 1), n1, s2, n2 - 1, t);

        // remove from s1's substring and do -1 to size
        int byRemoving = minOps(s1.substring(0, n1 - 1), n1 - 1, s2, n2, t);

        // replace last character of s1's substring with s2's last character
        int byReplacing = minOps(s1.substring(0, n1 - 1) + s2.charAt(n2 - 1), n1 - 1, s2, n2 - 1, t);

        // this 1 is for current operation performed (add or remove or update)
        return t[n1][n2] = 1 + Math.min(byAdding, Math.min(byRemoving, byReplacing));
    }


    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        int n1 = s1.length();
        int n2 = s2.length();

        Integer[][] t = new Integer[n1 + n2 + 1][n2 + 1];

        System.out.println(minOps(s1, n1, s2, n2, t));
    }
}
