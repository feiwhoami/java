/**
 * Given a linked list, determine if it has a cycle in it.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode141LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (null == head) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }
}
