/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 */
package leetcode;

public class LeetCode048RotateImage {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                int leftup = matrix[i][j];
                int rightup = matrix[j][n - i - 1];
                int rightbottom = matrix[n - i - 1][n - j - 1];
                int leftbottom = matrix[n - j - 1][i];

                matrix[j][n - i - 1] = leftup;
                matrix[n - i - 1][n - j - 1] = rightup;
                matrix[n - j - 1][i] = rightbottom;
                matrix[i][j] = leftbottom;
            }
        }

        if (n % 2 != 0) {
            int mid = half;
            for (int i = 0; i < mid; i++) {
                int leftup = matrix[i][mid];
                int rightup = matrix[mid][n - i - 1];
                int rightbottom = matrix[n - i - 1][n - mid - 1];
                int leftbottom = matrix[n - mid - 1][i];

                matrix[mid][n - i - 1] = leftup;
                matrix[n - i - 1][n - mid - 1] = rightup;
                matrix[n - mid - 1][i] = rightbottom;
                matrix[i][mid] = leftbottom;
            }
        }

        return;
    }
}
