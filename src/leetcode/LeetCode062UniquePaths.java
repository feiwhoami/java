/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 */

package leetcode;

public class LeetCode062UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] matrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }

        for (int j = 0; j < m; j++) {
            matrix[j][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[j][i] = matrix[j - 1][i] + matrix[j][i - 1];
            }
        }

        return matrix[m - 1][n - 1];

    }
}
