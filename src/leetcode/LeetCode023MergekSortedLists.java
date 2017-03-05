/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.util.ListNode;

public class LeetCode023MergekSortedLists {

    /**
     * Solution 1
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (0 == lists.length) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (null == l1) {
            curr.next = l2;
        }
        if (null == l2) {
            curr.next = l1;
        }

        return dummy.next;
    }

    /**
     * Solution 2
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        if (null == lists || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;

            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return dummy.next;
    }
}
