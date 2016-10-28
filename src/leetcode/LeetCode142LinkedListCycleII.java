/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode142LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (slow == dummy || fast == dummy || slow != fast) {
            if (null == fast || null == fast.next) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = dummy;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
