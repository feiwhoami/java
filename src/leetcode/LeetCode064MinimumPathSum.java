/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
package leetcode;

public class LeetCode064MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;

        int[][] minPath = new int[row][column];
        minPath[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            minPath[i][0] = minPath[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < column; j++) {
            minPath[0][j] = minPath[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                minPath[i][j] = grid[i][j] + Math.min(minPath[i - 1][j], minPath[i][j - 1]);
            }
        }

        return minPath[row - 1][column - 1];
    }
}
