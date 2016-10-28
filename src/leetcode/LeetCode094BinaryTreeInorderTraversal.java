/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree [1,null,2,3],
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

public class LeetCode094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);

        return result;

    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> result) {

        if (null == root) {
            return;
        }

        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);

    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean done = false;

        while (!done) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }
}
