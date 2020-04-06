/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode current = null;
        ListNode current1 = l1;
        ListNode current2 = l2;

        int carryon = 0;

        while (current1 != null || current2 != null || carryon != 0) {
            int sum = 0;

            if (null != current1) {
                sum = sum + current1.val;
            }
            if (null != current2) {
                sum = sum + current2.val;
            }

            sum = sum + carryon;

            ListNode next = new ListNode(sum % 10);
            carryon = (sum - sum % 10) / 10;

            if (null == head) {
                head = next;
                current = head;
            } else {
                current.next = next;
                current = next;
            }

            if (current1 != null) {
                current1 = current1.next;
            }
            if (current2 != null) {
                current2 = current2.next;
            }

        }

        return head;

    }

}
