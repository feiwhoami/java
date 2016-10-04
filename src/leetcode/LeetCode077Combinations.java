/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode077Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();

        combineHelper(curr, 1, n, k, result);

        return result;
    }

    private void combineHelper(List<Integer> curr, int index, int n, int k, List<List<Integer>> result) {

        if (curr.size() == k) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        if (index > n) {
            return;
        }

        for (int i = index; i <= n; i++) {
            curr.add(i);
            combineHelper(curr, i + 1, n, k, result);
            curr.remove(curr.size() - 1);
        }
    }
}
