/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode404SumofLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesHelper(root, false);
        return sum;
    }

    private void sumOfLeftLeavesHelper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (isLeaf(root) && isLeft) {
            sum = sum + root.val;
        } else {
            sumOfLeftLeavesHelper(root.left, true);
            sumOfLeftLeavesHelper(root.right, false);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

}
