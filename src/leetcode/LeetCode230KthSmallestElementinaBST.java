/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode230KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        int numOnLeft = countNode(root.left);

        if (numOnLeft == k - 1) {
            return root.val;
        } else if (numOnLeft <= k - 1) {
            return kthSmallest(root.right, k - numOnLeft - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int countNode(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return countNode(root.left) + countNode(root.right) + 1;
    }

}
