/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode105ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length != inorder.length) {
            return null;
        }

        int len = preorder.length;
        return buildTreeHelper(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        int rootPosition = findPosition(inorder, inStart, inEnd, rootValue);
        TreeNode rootNode = new TreeNode(rootValue);

        TreeNode left = buildTreeHelper(preorder, preStart + 1, preStart + rootPosition - inStart, inorder, inStart,
                rootPosition - 1);
        TreeNode right = buildTreeHelper(preorder, preEnd - inEnd + rootPosition + 1, preEnd, inorder, rootPosition + 1,
                inEnd);

        rootNode.left = left;
        rootNode.right = right;

        return rootNode;
    }

    private int findPosition(int[] nums, int start, int end, int key) {

        for (int i = start; i <= end; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
