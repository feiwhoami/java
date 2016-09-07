/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode023MergekSortedLists {

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

}
