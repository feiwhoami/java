/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
package leetcode;

public class LeetCode073SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        if (0 == row) {
            return;
        }
        int column = matrix[0].length;

        boolean clearFirstRow = false, clearFirstColumn = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                clearFirstColumn = true;
            }
        }

        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                clearFirstRow = true;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < column; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < column; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (clearFirstColumn) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

        if (clearFirstRow) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }

        return;
    }
}
