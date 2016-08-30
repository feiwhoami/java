/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode083RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (null == head) {
            return head;
        }

        ListNode curr = head;
        ListNode next = curr.next;

        while (null != next) {
            if (curr.val == next.val) {
                next = next.next;
            } else {
                curr.next = next;
                curr = next;
                next = next.next;
            }
        }

        curr.next = next;
        return head;
    }
}
