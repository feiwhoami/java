/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode106ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length != postorder.length) {
            return null;
        }

        int len = inorder.length;
        return buildTreeHelper(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        int rootPosition = findPosition(inorder, inStart, inEnd, rootValue);
        TreeNode rootNode = new TreeNode(rootValue);

        TreeNode left = buildTreeHelper(inorder, inStart, rootPosition - 1, postorder, postStart,
                postStart - inStart + rootPosition - 1);
        TreeNode right = buildTreeHelper(inorder, rootPosition + 1, inEnd, postorder, postEnd - inEnd + rootPosition,
                postEnd - 1);

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
