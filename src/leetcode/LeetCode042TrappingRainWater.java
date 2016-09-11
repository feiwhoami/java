/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
package leetcode;

public class LeetCode042TrappingRainWater {

    public int trap(int[] height) {

        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (height[i] > max) {
                left[i] = height[i];
                max = height[i];
            } else {
                left[i] = max;
            }
        }

        max = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            if (height[i] > max) {
                right[i] = height[i];
                max = height[i];
            } else {
                right[i] = max;
            }
        }

        int total = 0;
        for (int i = 0; i < length; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            if (water > 0) {
                total = total + water;
            }
        }

        return total;
    }
}
