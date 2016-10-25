/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode129SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {

        if (null == root) {
            return 0;
        }

        return sumNumbersHelper(root, root.val);
    }

    public int sumNumbersHelper(TreeNode root, int sum) {

        if (null == root.left && null == root.right) {
            return sum;
        }

        int result = 0;
        if (null != root.left) {
            result = result + sumNumbersHelper(root.left, sum * 10 + root.left.val);
        }
        if (null != root.right) {
            result = result + sumNumbersHelper(root.right, sum * 10 + root.right.val);
        }

        return result;
    }
}
