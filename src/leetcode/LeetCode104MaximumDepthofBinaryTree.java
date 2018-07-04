/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode104MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public int maxDepth2(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currDepth) {
        if (root == null) {
            return currDepth;
        }
        int left = helper(root.left, currDepth);
        int right = helper(root.right, currDepth);

        return Math.max(left, right) + 1;
    }

}
