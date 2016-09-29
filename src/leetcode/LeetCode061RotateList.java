/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode061RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (null == head || 0 == k) {
            return head;
        }

        int size = 0;
        ListNode curr = head;
        ListNode tail = null;

        while (curr != null) {
            if (null == curr.next) {
                tail = curr;
            }
            size++;
            curr = curr.next;
        }

        k = k % size;
        if (0 == k) {
            return head;
        }

        ListNode pre = head;
        curr = pre.next;
        int shift = size - k - 1;
        while (shift > 0) {
            pre = pre.next;
            curr = curr.next;
            shift--;
        }

        tail.next = head;
        pre.next = null;

        return curr;
    }
}
