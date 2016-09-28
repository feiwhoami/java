/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 */
package leetcode;

public class LeetCode055JumpGame {

    public boolean canJump(int[] nums) {

        int start = 0, end = 0;

        while (start <= end && end < nums.length) {

            int maxCover = end;
            for (int i = start; i <= end; i++) {

                if (nums[i] + i > maxCover) {
                    maxCover = nums[i] + i;
                }

                if (maxCover >= nums.length - 1) {
                    return true;
                }
            }

            start = end + 1;
            end = maxCover;
        }
        return false;
    }
}
