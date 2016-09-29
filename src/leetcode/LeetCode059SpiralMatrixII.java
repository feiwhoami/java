/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
package leetcode;

public class LeetCode059SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int x = 0, y = 0;
        int number = 1;

        while (n > 0) {
            if (1 == n) {
                matrix[x][y] = number;
                break;
            }
            // top
            for (int i = 0; i < n - 1; i++) {
                matrix[x][y++] = number++;
            }

            // right
            for (int i = 0; i < n - 1; i++) {
                matrix[x++][y] = number++;
            }

            // bottom
            for (int i = 0; i < n - 1; i++) {
                matrix[x][y--] = number++;
            }

            // left
            for (int i = 0; i < n - 1; i++) {
                matrix[x--][y] = number++;
            }

            n = n - 2;
            x++;
            y++;
        }

        return matrix;
    }
}
