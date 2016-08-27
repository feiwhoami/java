/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
package leetcode;

import leetcode.util.ListNode;

public class LeetCode160IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (null == headA || null == headB) {
            return null;
        }

        int lengthA = 1;
        int lengthB = 1;

        ListNode currA = headA;
        while (null != currA) {
            currA = currA.next;
            lengthA++;
        }

        ListNode currB = headB;
        while (null != currB) {
            currB = currB.next;
            lengthB++;
        }

        currA = headA;
        currB = headB;

        if (lengthA > lengthB) {
            while (lengthA != lengthB) {
                currA = currA.next;
                lengthA--;
            }
        } else if (lengthB > lengthA) {
            while (lengthA != lengthB) {
                currB = currB.next;
                lengthB--;
            }
        }

        while (null != currA || null != currB) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}
