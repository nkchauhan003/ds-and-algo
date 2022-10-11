package com.cb.backtracking;

public class NQueenProblem {
    public static void nQueen(int n) {

        int board[][] = new int[n][n];
        solveNQueen(board, 0, n);

        // print positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.println(i + "," + j);
                }
            }
        }
    }

    public static boolean solveNQueen(int board[][], int column, int n) {

        // all queens are placed
        if (column == n)
            return true;


        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, column, n)) {
                board[row][column] = 1;

                // try to place remaining queens
                if (solveNQueen(board, column + 1, n))
                    return true;

                // else BACKTRACK
                board[row][column] = 0;
            }
        }

        // can't place the queen
        return false;
    }

    public static boolean isSafe(int board[][], int row, int column, int n) {

        // check this row on left side
        for (int c = column - 1; c >= 0; c--)
            if (board[row][c] == 1)
                return false;

        // check in top left diagonal
        for (int c = column - 1, r = row - 1; c >= 0 && r >= 0; c--, r--)
            if (board[r][c] == 1)
                return false;

        // check in bottom left diagonal
        for (int c = column - 1, r = row + 1; c >= 0 && r < n; c--, r++)
            if (board[r][c] == 1)
                return false;

        return true;
    }

    public static void main(String[] args) {
        nQueen(4);
    }
}
