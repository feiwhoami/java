/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode051NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<List<String>>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solveNQueensHelper(board, 0, result);

        return result;
    }

    private void solveNQueensHelper(char[][] board, int index, List<List<String>> result) {

        int n = board.length;

        if (index == n) {

            List<String> newSolution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String newLine = new String(board[i]);
                newSolution.add(newLine);
            }

            result.add(newSolution);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(board, index, j)) {
                board[index][j] = 'Q';
                solveNQueensHelper(board, index + 1, result);
                board[index][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int i, int j) {

        int n = board.length;
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q') {
                return false;
            }
        }

        int x = i, y = j;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 'Q') {
                return false;
            }
            x--;
            y--;
        }

        x = i;
        y = j;
        while (x >= 0 && y < n) {
            if (board[x][y] == 'Q') {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }

}
