/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
package leetcode;

public class LeetCode084LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {

        if (null == heights) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {

            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }

            int minBar = heights[i];
            for (int j = i; j >= 0; j--) {

                minBar = Math.min(minBar, heights[j]);
                int area = minBar * (i - j + 1);

                max = Math.max(area, max);
            }
        }

        return max;
    }

    public int largestRectangleArea2(int[] heights) {

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
