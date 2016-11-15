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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class LeetCode199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);

        rightSideViewHelper(result, currLevel);

        return result;
    }

    private void rightSideViewHelper(List<Integer> result, Queue<TreeNode> currLevel) {
        if (null == currLevel || currLevel.size() == 0) {
            return;
        }

        Queue<TreeNode> nextLevel = new LinkedList<>();

        while (currLevel.size() != 1) {
            TreeNode node = currLevel.poll();
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }

        TreeNode last = currLevel.poll();
        result.add(last.val);
        if (last.left != null) {
            nextLevel.add(last.left);
        }
        if (last.right != null) {
            nextLevel.add(last.right);
        }

        rightSideViewHelper(result, nextLevel);
    }
}
