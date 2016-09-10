/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
package leetcode;

public class LeetCode041FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
