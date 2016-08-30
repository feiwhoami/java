/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 */
package leetcode;

import java.util.Random;

import leetcode.util.ListNode;

public class LeetCode382LinkedListRandomNode {

    ListNode head;
    int length;

    /**
     * @param head
     *            The linked list's head. Note that the head is guaranteed to be
     *            not null, so it contains at least one node.
     */
    public LeetCode382LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.length = 0;

        ListNode curr = head;
        while (null != curr) {
            length++;
            curr = curr.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {

        if (null == this.head) {
            return 0;
        }

        int result = this.head.val;
        int i = 2;

        ListNode curr = head.next;
        while (null != curr) {
            Random random = new Random();
            int t = random.nextInt(i);
            if (t == 0) {
                result = curr.val;
            }
            curr = curr.next;
            i++;
        }

        return result;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom2() {

        Random random = new Random();
        int i = random.nextInt(length);

        ListNode result = head;
        while (i > 0) {
            result = result.next;
            i--;
        }

        return result.val;

    }
}
