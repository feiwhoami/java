/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */

package leetcode;

import leetcode.util.TreeNode;

public class LeetCode111MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if (l == 0) {
            return r + 1;
        }
        if (r == 0) {
            return l + 1;
        }

        return Math.min(l, r) + 1;
    }

}
