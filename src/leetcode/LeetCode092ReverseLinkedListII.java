/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode092ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (null == head || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (null == head) {
                return null;
            }
            head = head.next;
        }

        ListNode firstPre = head;
        ListNode first = head.next;
        ListNode second = first;
        ListNode secondNext = second.next;

        for (int i = m; i < n; i++) {
            ListNode tmp = secondNext.next;
            secondNext.next = second;
            second = secondNext;
            secondNext = tmp;
        }

        first.next = secondNext;
        firstPre.next = second;

        return dummy.next;
    }
}
