/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

package leetcode;

import java.util.HashSet;

public class LeetCode36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> hash = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (hash.contains(board[i][j])) {
                    return false;
                }
                hash.add(board[i][j]);
            }
            hash.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (hash.contains(board[j][i])) {
                    return false;
                }
                hash.add(board[j][i]);
            }
            hash.clear();
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (board[i + ii][j + jj] == '.') {
                            continue;
                        }
                        if (hash.contains(board[i + ii][j + jj])) {
                            return false;
                        }
                        hash.add(board[i + ii][j + jj]);
                    }
                }
                hash.clear();
            }
        }

        return true;
    }
}
