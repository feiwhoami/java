/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 */
package leetcode;

public class LeetCode085MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int column = matrix[0].length;
        int[][] matrixInt = new int[row][column];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                int height = 0;
                int k = i;
                while (k >= 0 && matrix[k][j] == '1') {
                    height++;
                    k--;
                }
                matrixInt[i][j] = height;
            }
        }

        int area = Integer.MIN_VALUE;
        for (int i = row - 1; i >= 0; i--) {
            area = Math.max(area, largestRectangleArea(matrixInt[i]));
        }

        return area;
    }

    private int largestRectangleArea(int[] heights) {

        int size = heights.length;
        if (size == 0) {
            return 0;
        }

        int[] stack = new int[size + 1];
        int[] width = new int[size + 1];

        int area = Integer.MIN_VALUE;
        int top = 0;
        int newHeight;

        for (int i = 0; i <= size; i++) {

            if (i < size) {
                newHeight = heights[i];
            } else {
                newHeight = -1;
            }

            if (newHeight > stack[top]) {
                top++;
                stack[top] = newHeight;
                width[top] = 1;
            } else {

                int minBar = Integer.MAX_VALUE;
                int wid = 0;
                while (top >= 0 && stack[top] > newHeight) {
                    minBar = Math.min(minBar, stack[top]);
                    wid = wid + width[top];
                    area = Math.max(area, minBar * wid);
                    top--;
                }

                top++;
                stack[top] = newHeight;
                width[top] = wid + 1;

            }
        }

        return area;
    }
}
