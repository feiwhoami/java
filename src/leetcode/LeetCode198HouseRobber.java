/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
package leetcode;

public class LeetCode198HouseRobber {

    public int rob(int[] nums) {

        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int length = nums.length;
        if (1 == length) {
            return nums[0];
        }

        int[] result = new int[length];

        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
        }

        return result[length - 1];
    }
}
