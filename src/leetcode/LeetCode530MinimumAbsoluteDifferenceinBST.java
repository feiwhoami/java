/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode530MinimumAbsoluteDifferenceinBST {
    private int minAbsDiff = Integer.MAX_VALUE;
    private TreeNode curr;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);

        return minAbsDiff;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        if (curr != null) {
            int diff = Math.abs(node.val - curr.val);
            minAbsDiff = Math.min(diff, minAbsDiff);
        }
        curr = node;

        helper(node.right);
    }
}
