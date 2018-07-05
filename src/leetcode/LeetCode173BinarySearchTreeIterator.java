/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
package leetcode;

import leetcode.util.TreeNode;

import java.util.Stack;

public class LeetCode173BinarySearchTreeIterator {

    private TreeNode curr;
    private Stack<TreeNode> stack;

    public LeetCode173BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (curr == null && stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        curr = stack.pop();
        int val = curr.val;

        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        return val;
    }
}
