/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package leetcode;

import java.util.Arrays;

public class LeetCode0163SumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    result = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                }
            }
        }

        return result;
    }
}
