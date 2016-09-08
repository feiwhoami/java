/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode025ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (null == head || 1 == k) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            head = reverseNextKNodes(head, k);
        }

        return dummy.next;
    }

    private ListNode reverseNextKNodes(ListNode head, int k) {

        ListNode next = head;

        for (int i = 0; i < k; i++) {
            if (null == next.next) {
                return next;
            }
            next = next.next;
        }

        next = next.next;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode node1 = head.next;

        while (curr != next) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        head.next = prev;
        node1.next = curr;

        return node1;
    }
}
