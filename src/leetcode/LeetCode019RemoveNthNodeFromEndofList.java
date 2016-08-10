/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 *    Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

package leetcode;

import leetcode.util.ListNode;

public class LeetCode019RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = new ListNode(0);
        ListNode currPre = new ListNode(0);

        currPre.next = curr;
        curr.next = head;

        ListNode fast = curr;
        ListNode dummy = curr;

        while (n > 0) {
            if (null == fast) {
                return head;
            }
            fast = fast.next;
            n--;
        }

        while (null != fast) {
            currPre = currPre.next;
            curr = curr.next;
            fast = fast.next;
        }

        currPre.next = curr.next;

        return dummy.next;

    }

}
