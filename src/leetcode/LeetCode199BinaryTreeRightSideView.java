/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 */
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);

        rightSideViewHelper(result, currLevel);

        return result;
    }

    private void rightSideViewHelper(List<Integer> result, Queue<TreeNode> currLevel) {
        if (currLevel == null || currLevel.size() == 0) {
            return;
        }

        Queue<TreeNode> nextLevel = new LinkedList<>();

        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.poll();
            if (currLevel.isEmpty()) {
                result.add(node.val);
            }
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }

        rightSideViewHelper(result, nextLevel);
    }
}
