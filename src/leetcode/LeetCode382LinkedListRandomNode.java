/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 */
package leetcode;

import java.util.Random;

import leetcode.util.ListNode;

public class LeetCode382LinkedListRandomNode {

    private ListNode head;
    private int length;
    private Random random;

    /**
     * @param head
     *            The linked list's head. Note that the head is guaranteed to be
     *            not null, so it contains at least one node.
     */
    public LeetCode382LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.length = 0;
        this.random = new Random();

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

        int i = random.nextInt(length);

        ListNode result = head;
        while (i > 0) {
            result = result.next;
            i--;
        }

        return result.val;

    }
}
