/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode078Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();

        subsetsHelper(curr, 0, nums, result);

        return result;
    }

    private void subsetsHelper(List<Integer> curr, int index, int[] nums, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        subsetsHelper(curr, index + 1, nums, result);

        curr.add(nums[index]);
        subsetsHelper(curr, index + 1, nums, result);
        curr.remove(curr.size() - 1);
    }

}
