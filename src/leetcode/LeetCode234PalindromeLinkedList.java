/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode middle = findMiddle(head);
        middle = reverseList(middle);

        while (null != middle) {
            if (head.val != middle.val) {
                return false;
            }
            head = head.next;
            middle = middle.next;
        }

        return true;
    }

    private ListNode findMiddle(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (null != head) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }
}
