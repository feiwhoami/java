/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> curr = new ArrayList<>();

        combinationSumHelper(candidates, curr, 0, target, result);

        return result;
    }

    private void combinationSumHelper(int[] candidates, List<Integer> curr, int index, int target,
            List<List<Integer>> result) {

        if (0 == target) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        int prev = -1;

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (prev != -1 && prev == candidates[i]) {
                continue;
            }

            curr.add(candidates[i]);
            combinationSumHelper(candidates, curr, i, target - candidates[i], result);
            curr.remove(curr.size() - 1);

            prev = candidates[i];
        }
    }
}
