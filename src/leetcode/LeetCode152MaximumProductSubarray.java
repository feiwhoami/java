/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
package leetcode;

public class LeetCode152MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int len = nums.length;
        int result = nums[0];

        int[] min = new int[len];
        int[] max = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = Integer.MAX_VALUE;
            max[i] = Integer.MIN_VALUE;
        }

        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < len; i++) {
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            result = Math.max(max[i], result);
        }
        return result;
    }
}
