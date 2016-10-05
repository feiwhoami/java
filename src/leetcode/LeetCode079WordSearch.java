/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
package leetcode;

public class LeetCode079WordSearch {

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        if (row == 0) {
            return false;
        }
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found = existHelper(i, j, 0, visited, board, word);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existHelper(int i, int j, int index, boolean[][] visited, char[][] board, String word) {

        if (index == word.length()) {
            return true;
        }

        int row = board.length;
        int column = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column || board[i][j] != word.charAt(index) || visited[i][j] == true) {
            return false;
        }

        visited[i][j] = true;
        boolean found = existHelper(i - 1, j, index + 1, visited, board, word)
                || existHelper(i + 1, j, index + 1, visited, board, word)
                || existHelper(i, j - 1, index + 1, visited, board, word)
                || existHelper(i, j + 1, index + 1, visited, board, word);
        visited[i][j] = false;

        return found;
    }
}
