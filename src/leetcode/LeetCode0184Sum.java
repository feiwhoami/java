/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0184Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (null == nums || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        List<Integer> four = new ArrayList<>();
                        four.add(nums[i]);
                        four.add(nums[j]);
                        four.add(nums[l]);
                        four.add(nums[r]);
                        result.add(four);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
