/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode090SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        result.add(curr);

        Arrays.sort(nums);

        subsetsWithDupHelper(curr, nums, 0, result);

        return result;
    }

    private void subsetsWithDupHelper(List<Integer> curr, int[] nums, int index, List<List<Integer>> result) {

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            curr.add(nums[i]);
            result.add(new ArrayList<Integer>(curr));
            subsetsWithDupHelper(curr, nums, i + 1, result);
            curr.remove(curr.size() - 1);
        }
    }
}
