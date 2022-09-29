package com.cb.matrix;

/*
 * Time: O(n^2)
 * Space: O(n^2)
 * */
public class M3_RotateMatrix_extraSpace {

    private static int[][] rotate(int[][] matrix, int m, int n) {

        int[][] tmp = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][(m - 1) - i] = matrix[i][j];
            }
        }
        return tmp;
    }

    public static void main(String[] args) {

        int[][] mtx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int m = mtx.length;
        int n = m < 1 ? 0 : mtx[0].length;

        printMatrix(mtx, m, n);
        int[][] rotatedMtx = rotate(mtx, m, n);
        printMatrix(rotatedMtx, rotatedMtx.length, rotatedMtx[0].length);
    }

    private static void printMatrix(int mtx[][], int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mtx[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
