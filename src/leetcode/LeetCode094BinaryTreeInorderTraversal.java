/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 */
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean done = false;

        while (!done) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    curr = stack.pop();
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while (curr != null)  {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
