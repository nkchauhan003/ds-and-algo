package com.cb.matrix;

/*
 * Time: O(n^2)
 * Space: O(n)
 * */
public class M3_RotateMatrix_nXn_in_constantSpace {

    private static void rotate(int[][] matrix, int n) {
        // interchange rows and columns
        transpose(matrix, n);
        reverseRows(matrix, n);
    }

    private static void reverseRows(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            int s = 0, e = n - 1;
            int arr[] = matrix[i];
            while (e > s) {
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                e--;
                s++;
            }
        }
    }

    private static void transpose(int[][] matrix, int n) {

        for (int i = 0; i < n; i++) {
            // visit elements only once i.e. j=i+1
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    public static void main(String[] args) {

        int[][] mtx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = mtx.length;

        printMatrix(mtx, n, n);
        rotate(mtx, n);
        printMatrix(mtx, n, n);
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
