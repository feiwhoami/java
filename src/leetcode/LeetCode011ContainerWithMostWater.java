/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */
package leetcode;

public class LeetCode011ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (null == height || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
