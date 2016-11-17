/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
package leetcode;

public class LeetCode209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        while (right < nums.length) {
            while (sum < s && right < nums.length) {
                sum = sum + nums[right];
                right++;
            }
            while (sum >= s) {
                minSize = Math.min(minSize, right - left);
                sum = sum - nums[left];
                left++;
            }
        }

        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }
        return minSize;
    }
}
