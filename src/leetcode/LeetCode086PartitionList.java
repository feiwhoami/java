/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode086PartitionList {

    public ListNode partition(ListNode head, int x) {

        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        ListNode last = dummy;

        while (curr != null && curr.next != null) {

            if (curr.next.val >= x) {
                curr = curr.next;
            } else {
                if (curr == last) {
                    curr = curr.next;
                } else {
                    ListNode lastNext = last.next;
                    ListNode currNext = curr.next;

                    last.next = currNext;
                    curr.next = currNext.next;
                    currNext.next = lastNext;
                }

                last = last.next;
            }
        }

        return dummy.next;
    }
}
