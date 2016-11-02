/**
 * Sort a linked list using insertion sort.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode curr1 = head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        while (curr1 != null) {
            ListNode curr2 = dummy;
            ListNode newNode = new ListNode(curr1.val);
            while (curr2.next != null && curr2.next.val < curr1.val) {
                curr2 = curr2.next;
            }

            if (curr2.next == null) {
                curr2.next = newNode;
            } else {
                ListNode tmp = curr2.next;
                curr2.next = newNode;
                newNode.next = tmp;
            }
            curr1 = curr1.next;
        }

        return dummy.next;
    }
}
