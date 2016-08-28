/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
package leetcode;

public class LeetCode303RangeSumQueryImmutable {

    private int[] sum;

    public LeetCode303RangeSumQueryImmutable(int[] nums) {

        if (null != nums && 0 != nums.length) {
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {

        if (j >= sum.length) {
            return 0;
        }

        if (0 == i) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }

}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);