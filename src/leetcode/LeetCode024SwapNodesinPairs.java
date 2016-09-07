/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode024SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {

        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;

        while (null != curr && null != curr.next) {
            ListNode next = curr.next;
            pre.next = next;
            curr.next = next.next;
            next.next = curr;

            pre = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
