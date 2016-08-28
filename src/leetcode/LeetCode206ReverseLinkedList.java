/**
 * Reverse a singly linked list.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (null != second) {
            ListNode next = second.next;
            second.next = first;
            first = second;
            second = next;
        }

        head.next = null;
        return first;
    }
}
