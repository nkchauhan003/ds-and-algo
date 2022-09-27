package com.cb.matrix;

/*
 * Time: O(m * n)
 * Space: O(1)
 * */
public class M1_SetMatrixZeroes_mn_time_constant_space {

    private static void setMatrixZero(int mtx[][], int m, int n) {

        int col00 = 1;

        // identify rows and columns to be zeroed
        for (int r = 0; r < m; r++) {
            if (mtx[r][0] == 0)
                col00 = 0;
            for (int c = 1; c < n; c++) {
                if (mtx[r][c] == 0) {

                    // columns to be deleted
                    // first row
                    mtx[0][c] = 0;

                    // rows to be deleted
                    // first column
                    mtx[r][0] = 0;
                }
            }
        }

        // mark zero based on 'column[]' and 'rows[]'
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 1; c--) {
                if (mtx[0][c] == 0 || mtx[r][0] == 0) {
                    mtx[r][c] = 0;
                }
            }
            if (col00 == 0)
                mtx[r][0] = 0;
        }
    }

    public static void main(String[] args) {
        int mtx[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        int m = mtx.length;
        int n = m > 0 ? mtx[0].length : 0;

        printMatrix(mtx, m, n);
        setMatrixZero(mtx, m, n);
        printMatrix(mtx, m, n);
    }

    private static void printMatrix(int mtx[][], int m, int n) {
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(mtx[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
