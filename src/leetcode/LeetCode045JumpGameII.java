/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Note:
 * You can assume that you can always reach the last index.
 */
package leetcode;

public class LeetCode045JumpGameII {

    public int jump(int[] nums) {

        int length = nums.length;
        int[] steps = new int[length];

        steps[0] = 0;

        for (int i = 1; i < length; i++) {
            int minJump = Integer.MAX_VALUE;
            int j = 0;
            while (j < i) {
                if (i - j <= nums[j] && steps[j] + 1 < minJump) {
                    minJump = steps[j] + 1;
                }
                j++;
            }
            steps[i] = minJump;
        }

        return steps[length - 1];
    }

    public int jump2(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int start = 0, end = 0, jump = 0;

        while (end < nums.length - 1) {
            jump++;
            int maxCover = end;

            for (int i = start; i <= end; i++) {
                if (nums[i] + i > maxCover) {
                    maxCover = nums[i] + i;
                }
            }
            start = end + 1;
            end = maxCover;
        }

        return jump;
    }

}
