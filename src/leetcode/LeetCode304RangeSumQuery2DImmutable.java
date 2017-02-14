/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
package leetcode;

public class LeetCode304RangeSumQuery2DImmutable {

    private int[][] sum; // sum from upper-left to current
    private int[][] rowSum; // sum from left to current in one row
    private int[][] columnSum; // sum from top to current in one column

    public LeetCode304RangeSumQuery2DImmutable(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int column = matrix[0].length;

        sum = new int[row][column];
        rowSum = new int[row][column];
        columnSum = new int[row][column];
        sum[0][0] = matrix[0][0];
        rowSum[0][0] = matrix[0][0];
        columnSum[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
            columnSum[i][0] = columnSum[i - 1][0] + matrix[i][0];
            rowSum[i][0] = matrix[i][0];
        }

        for (int j = 1; j < column; j++) {
            sum[0][j] = sum[0][j - 1] + matrix[0][j];
            rowSum[0][j] = rowSum[0][j - 1] + matrix[0][j];
            columnSum[0][j] = matrix[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                columnSum[i][j] = columnSum[i - 1][j] + matrix[i][j];
                rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j];
                sum[i][j] = sum[i - 1][j - 1] + columnSum[i][j] + rowSum[i][j] - matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        }

        if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        }

        if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }

        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}
