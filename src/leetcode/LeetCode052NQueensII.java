package leetcode;

public class LeetCode052NQueensII {

    private int totalCount;

    public LeetCode052NQueensII() {
        totalCount = 0;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        totalNQueensHelper(board, 0);

        return totalCount;
    }

    private void totalNQueensHelper(char[][] board, int index) {

        int n = board.length;
        if (index == n) {
            totalCount++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(board, index, j)) {
                board[index][j] = 'Q';
                totalNQueensHelper(board, index + 1);
                board[index][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int i, int j) {

        int n = board.length;

        for (int k = 0; k < n; k++) {
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
