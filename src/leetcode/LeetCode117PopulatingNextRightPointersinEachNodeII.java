/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 */
package leetcode;

import leetcode.util.TreeLinkNode;

public class LeetCode117PopulatingNextRightPointersinEachNodeII {

    public void connect(TreeLinkNode root) {

        if (null == root) {
            return;
        }

        // first node of each level
        TreeLinkNode first = root;

        while (first != null) {

            TreeLinkNode curr = first;
            first = null;
            TreeLinkNode pre = null;

            while (curr != null) {

                if (curr.left == null && curr.right == null) {
                    curr = curr.next;
                } else if (curr.left != null && curr.right != null) {
                    if (pre == null) {
                        pre = curr.left;
                        first = pre;
                    } else {
                        pre.next = curr.left;
                    }

                    curr.left.next = curr.right;
                    pre = curr.right;
                    curr = curr.next;
                } else if (curr.left != null && curr.right == null) {
                    if (pre == null) {
                        pre = curr.left;
                        first = pre;
                    } else {
                        pre.next = curr.left;
                    }

                    pre = curr.left;
                    curr = curr.next;
                } else if (curr.left == null && curr.right != null) {
                    if (pre == null) {
                        pre = curr.right;
                        first = pre;
                    } else {
                        pre.next = curr.right;
                    }

                    pre = curr.right;
                    curr = curr.next;
                }
            }
        }

        return;
    }
}
