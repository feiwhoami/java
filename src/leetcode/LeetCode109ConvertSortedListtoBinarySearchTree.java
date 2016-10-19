/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
package leetcode;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

public class LeetCode109ConvertSortedListtoBinarySearchTree {

    private ListNode curr = null;

    public TreeNode sortedListToBST(ListNode head) {

        if (null == head) {
            return null;
        }

        curr = head;

        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        return sortedListToBSTHelper(0, len - 1);

    }

    private TreeNode sortedListToBSTHelper(int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(start, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        root.left = left;

        curr = curr.next;
        TreeNode right = sortedListToBSTHelper(mid + 1, end);
        root.right = right;

        return root;
    }
}
