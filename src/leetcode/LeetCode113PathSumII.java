/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each
 * path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(root, curr, sum, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> curr, int target,
                        List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (root.val == target && root.left == null && root.right == null) {
            curr.add(root.val);
            result.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        curr.add(root.val);
        helper(root.left, curr, target - root.val, result);
        helper(root.right, curr, target - root.val, result);
        curr.remove(curr.size() - 1);
    }
}
