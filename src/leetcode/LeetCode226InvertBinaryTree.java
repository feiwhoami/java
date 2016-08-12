/**
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (null == root) {
            return null;
        }

        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
