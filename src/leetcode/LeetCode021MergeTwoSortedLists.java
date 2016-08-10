/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */

package leetcode;

import leetcode.util.ListNode;

public class LeetCode021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (null == l1) {
            curr.next = l2;
        }
        if (null == l2) {
            curr.next = l1;
        }

        return dummy.next;
    }

}
