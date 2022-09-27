package com.cb.matrix;

/*
 * Time: O(m * n)
 * Space: O(m + n)
 * */
public class M1_SetMatrixZeroes_mn_time_m_plus_n_space {

    private static void setMatrixZero(int mtx[][], int m, int n) {

        // columns to be zeroed
        int column[] = new int[n];

        // rows to be zeroed
        int rows[] = new int[m];

        // identify rows and columns to be zeroed
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mtx[r][c] == 0) {
                    column[c] = -1;
                    rows[r] = -1;
                }
            }
        }

        // mark zero based on 'column[]' and 'rows[]'
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (column[c] == -1 || rows[r] == -1) {
                    mtx[r][c] = 0;
                }
            }
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
