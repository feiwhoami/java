/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *     2
 *    / \
 *   1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *     1
 *    / \
 *   2   3
 * Binary tree [1,2,3], return false.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode98ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, Long min, Long max) {
        if (null == root) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTHelper(root.left, min, Long.valueOf(root.val))
                && isValidBSTHelper(root.right, Long.valueOf(root.val), max);

    }

}
