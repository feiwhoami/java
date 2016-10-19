/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode108ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (null == nums) {
            return null;
        }

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        TreeNode left = sortedArrayToBSTHelper(nums, start, mid - 1);
        TreeNode right = sortedArrayToBSTHelper(nums, mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}
