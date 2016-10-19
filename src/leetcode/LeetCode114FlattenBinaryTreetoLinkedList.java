/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 */
package leetcode;

import java.util.Stack;

import leetcode.util.TreeNode;

public class LeetCode114FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {

        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (pre != null) {
                pre.left = null;
                pre.right = curr;
            }
            pre = curr;
        }

        return;
    }
}
