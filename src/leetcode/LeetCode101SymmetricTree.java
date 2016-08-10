/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

public class LeetCode101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if (null == p && null == q) {
                continue;
            }

            if (null == p || null == q) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }

        return true;

    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {

        if (null == p && null == q) {
            return true;
        }

        if (null == p || null == q) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
