/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130SurroundedRegions {

    private class Position {
        public int x;
        public int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {

        int row = board.length;
        if (row == 0) {
            return;
        }
        int column = board[0].length;

        for (int i = 0; i < row; i++) {
            fill(board, i, 0);
            fill(board, i, column - 1);
        }

        for (int j = 0; j < column; j++) {
            fill(board, 0, j);
            fill(board, row - 1, j);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    private void fill(char[][] board, int i, int j) {

        int row = board.length;
        if (row == 0 || i >= row) {
            return;
        }
        int column = board[0].length;
        if (j >= column) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        Queue<Position> queue = new LinkedList<Position>();
        board[i][j] = '#';
        queue.add(new Position(i, j));

        while (!queue.isEmpty()) {

            Position curr = queue.poll();
            int x = curr.x;
            int y = curr.y;

            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                queue.add(new Position(x - 1, y));
                board[x - 1][y] = '#';
            }
            if (x + 1 < row && board[x + 1][y] == 'O') {
                queue.add(new Position(x + 1, y));
                board[x + 1][y] = '#';
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                queue.add(new Position(x, y - 1));
                board[x][y - 1] = '#';
            }
            if (y + 1 < column && board[x][y + 1] == 'O') {
                queue.add(new Position(x, y + 1));
                board[x][y + 1] = '#';
            }
        }

        return;
    }
}
