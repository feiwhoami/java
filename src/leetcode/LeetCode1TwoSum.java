/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

package leetcode;

import java.util.HashMap;

public class LeetCode1TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] result = {};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(target - nums[i])) {
                result = new int[] { map.get(target - nums[i]), i };
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
