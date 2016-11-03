/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
package leetcode;

public class LeetCode164MaximumGap {

    public int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int numMin = Integer.MAX_VALUE;
        int numMax = Integer.MIN_VALUE;

        int[] localMin = new int[nums.length];
        int[] localMax = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numMin = Math.min(numMin, nums[i]);
            numMax = Math.max(numMax, nums[i]);

            localMin[i] = Integer.MAX_VALUE;
            localMax[i] = Integer.MIN_VALUE;
        }

        int average = (int) Math.ceil((double) (numMax - numMin) / (double) (nums.length - 1));

        if (average == 0) {
            average++;
        }

        for (int i = 0; i < nums.length; i++) {
            int p = (nums[i] - numMin) / average;
            localMin[p] = Math.min(localMin[p], nums[i]);
            localMax[p] = Math.max(localMax[p], nums[i]);
        }

        int max = 0;
        int left = 0;

        while (localMin[left] == Integer.MAX_VALUE && localMax[left] == Integer.MIN_VALUE) {
            left++;
        }

        while (left < nums.length - 1) {
            int right = left + 1;
            while (right < nums.length && localMin[right] == Integer.MAX_VALUE) {
                right++;
            }
            if (right == nums.length) {
                break;
            }
            max = Math.max(max, localMin[right] - localMax[left]);
            left = right;
        }
        return max;
    }
}
