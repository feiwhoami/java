/**
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

 * Example 1:
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.

 * Example 2:
 * Input: matrix = [[1,2],[2,2]]
 * Output: false
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 */
package leetcode;

public class LeetCode766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            int val = matrix[0][j];
            int x = 0;
            int y = j;
            while (x < rows && y < cols) {
                if (val != matrix[x][y]){
                    return false;
                }
                x++;
                y++;
            }
        }

        for (int i = 0; i < rows; i++) {
            int val = matrix[i][0];
            int x = i;
            int y = 0;
            while (x < rows && y < cols) {
                if (val != matrix[x][y]){
                    return false;
                }
                x++;
                y++;
            }
        }

        return true;
    }
}
