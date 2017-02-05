/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
package leetcode;

public class LeetCode289GameofLife {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        if (m == 0) {
            return;
        }

        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;

                if (i - 1 >= 0) {
                    if (board[i - 1][j] == 1 || board[i - 1][j] == 2) {
                        lives++;
                    }
                }

                if (i + 1 < m) {
                    if (board[i + 1][j] == 1 || board[i + 1][j] == 2) {
                        lives++;
                    }
                }

                if (j - 1 >= 0) {
                    if (board[i][j - 1] == 1 || board[i][j - 1] == 2) {
                        lives++;
                    }
                }

                if (j + 1 < n) {
                    if (board[i][j + 1] == 1 || board[i][j + 1] == 2) {
                        lives++;
                    }
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) {
                        lives++;
                    }
                }

                if (i - 1 >= 0 && j + 1 < n) {
                    if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) {
                        lives++;
                    }
                }

                if (i + 1 < m && j - 1 >= 0) {
                    if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2) {
                        lives++;
                    }
                }

                if (i + 1 < m && j + 1 < n) {
                    if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2) {
                        lives++;
                    }
                }

                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
