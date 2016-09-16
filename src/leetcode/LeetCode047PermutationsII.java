/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode047PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null) {
            return result;
        }

        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        int[] visited = new int[nums.length];

        permuteUniqueHelper(curr, result, visited, nums);

        return result;
    }

    private void permuteUniqueHelper(List<Integer> curr, List<List<Integer>> result, int[] visited, int[] nums) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }

            visited[i] = 1;
            curr.add(nums[i]);
            permuteUniqueHelper(curr, result, visited, nums);
            curr.remove(curr.size() - 1);
            visited[i] = 0;
        }
    }
}
