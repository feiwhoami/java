/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode113PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> curr = new ArrayList<>();

        pathSumHelper(root, curr, sum, result);

        return result;
    }

    private void pathSumHelper(TreeNode root, List<Integer> curr, int target, List<List<Integer>> result) {
        if (null == root) {
            return;
        }

        if (root.val == target && null == root.left && null == root.right) {
            curr.add(root.val);
            result.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        curr.add(root.val);
        pathSumHelper(root.left, curr, target - root.val, result);
        pathSumHelper(root.right, curr, target - root.val, result);
        curr.remove(curr.size() - 1);
    }
}
