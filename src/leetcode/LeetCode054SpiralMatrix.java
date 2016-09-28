/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode054SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        if (0 == m) {
            return result;
        }

        int n = matrix[0].length;
        int x = 0;
        int y = 0;

        while (m > 0 && n > 0) {

            if (1 == m) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y]);
                    y++;
                }
                break;
            }

            if (1 == n) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x][y]);
                    x++;
                }
                break;
            }

            // top
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y]);
                y++;
            }

            // right
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x][y]);
                x++;
            }

            // bottom
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y]);
                y--;
            }

            // left
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x][y]);
                x--;
            }

            m = m - 2;
            n = n - 2;
            x++;
            y++;
        }

        return result;
    }

}
