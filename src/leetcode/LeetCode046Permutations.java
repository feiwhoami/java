/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode046Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            curr.add(nums[i]);
        }

        permuteHelper(curr, 0, result);

        return result;
    }

    private void permuteHelper(List<Integer> curr, int index, List<List<Integer>> result) {

        if (index == curr.size() - 1) {
            result.add(new ArrayList<Integer>(curr));
        }

        for (int i = index; i < curr.size(); i++) {
            int tmpI = curr.get(i);
            int tmpIndex = curr.get(index);
            curr.set(i, tmpIndex);
            curr.set(index, tmpI);

            permuteHelper(curr, index + 1, result);

            curr.set(i, tmpI);
            curr.set(index, tmpIndex);
        }
    }

}
