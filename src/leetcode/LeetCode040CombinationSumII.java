/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode040CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> curr = new ArrayList<Integer>();

        combinationSum2Helper(candidates, target, 0, curr, result);

        HashSet<List<Integer>> hash = new HashSet<>();
        hash.addAll(result);
        result.clear();
        result.addAll(hash);

        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, int index, List<Integer> curr,
            List<List<Integer>> result) {

        if (0 == target) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            curr.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }

        return;
    }
}
