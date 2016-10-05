/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode082RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (null != curr.next) {

            ListNode start = curr.next;
            ListNode end = curr.next;
            while (null != end.next && end.next.val == start.val) {
                end = end.next;
            }

            if (start == end) {
                curr = curr.next;
            } else {
                curr.next = end.next;
            }
        }

        return dummy.next;
    }
}
