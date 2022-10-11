package com.cb.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblemAllCombination {
    public static List<List<Integer>> nQueen(int n) {

        int board[][] = new int[n][n];

        List<List<Integer>> positions = new ArrayList<>();
        solveNQueen(board, 0, n, positions);

        return positions;
    }

    public static void solveNQueen(int board[][], int column, int n, List<List<Integer>> positions) {

        // all queens are placed
        if (column == n) {
            // add combination
            List<Integer> position = new ArrayList<>();
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] == 1) {
                        position.add(j + 1);
                    }
                }
            }
            positions.add(position);
            // stop this recursive call
            return;
        }


        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, column, n)) {
                board[row][column] = 1;

                // try to place remaining queens
                solveNQueen(board, column + 1, n, positions);

                // else BACKTRACK
                board[row][column] = 0;
            }
        }
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
        System.out.println(nQueen(4));
    }
}
