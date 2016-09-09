/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 */
package leetcode;

import java.util.HashSet;

public class LeetCode037SudokuSolver {

    public void solveSudoku(char[][] board) {

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char) (k + '0');

                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int a, int b) {

        HashSet<Character> hash = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if ('.' == board[a][i]) {
                continue;
            }
            if (hash.contains(board[a][i])) {
                return false;
            }
            hash.add(board[a][i]);

        }
        hash.clear();

        for (int i = 0; i < 9; i++) {

            if ('.' == board[i][b]) {
                continue;
            }
            if (hash.contains(board[i][b])) {
                return false;
            }
            hash.add(board[i][b]);

        }
        hash.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int x = a / 3 * 3 + i;
                int y = b / 3 * 3 + j;

                if ('.' == board[x][y]) {
                    continue;
                }
                if (hash.contains(board[x][y])) {
                    return false;
                }
                hash.add(board[x][y]);
            }
        }

        return true;
    }
}
