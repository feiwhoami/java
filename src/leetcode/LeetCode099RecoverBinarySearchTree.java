/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode099RecoverBinarySearchTree {

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (first == null && root.val < lastElement.val) {
            first = lastElement;
        }
        if (first != null && root.val < lastElement.val) {
            second = root;
        }
        lastElement = root;
        inorder(root.right);
    }
}
