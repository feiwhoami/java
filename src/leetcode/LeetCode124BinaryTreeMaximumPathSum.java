/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode124BinaryTreeMaximumPathSum {

    private class ResultType {

        private int singlePath;
        private int maxPath;

        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType maxPathSumHelper(TreeNode root) {

        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        ResultType left = maxPathSumHelper(root.left);
        ResultType right = maxPathSumHelper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath);
        singlePath = root.val + Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, Math.max(0, left.singlePath) + Math.max(0, right.singlePath) + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {

        ResultType result = maxPathSumHelper(root);
        return result.maxPath;
    }

}
