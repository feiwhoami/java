/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.RandomListNode;

public class LeetCode138CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (null == head) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode currCopy = new RandomListNode(curr.label);
            map.put(curr, currCopy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            RandomListNode currCopy = map.get(curr);
            currCopy.next = map.get(curr.next);
            currCopy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
