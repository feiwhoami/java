/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == root) {
            return result;
        }

        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);

        zigzagLevelOrderHelper(curr, result, true);

        return result;
    }

    private void zigzagLevelOrderHelper(List<TreeNode> currentLevel, List<List<Integer>> result, boolean leftToRight) {

        if (null == currentLevel || currentLevel.isEmpty()) {
            return;
        }

        List<Integer> currentLevelInteger = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        if (leftToRight) {
            for (int i = 0; i < currentLevel.size(); i++) {
                if (currentLevel.get(i) != null) {
                    currentLevelInteger.add(currentLevel.get(i).val);
                }
            }
        } else {
            for (int i = currentLevel.size() - 1; i >= 0; i--) {
                if (currentLevel.get(i) != null) {
                    currentLevelInteger.add(currentLevel.get(i).val);
                }
            }
        }

        for (int i = 0; i < currentLevel.size(); i++) {
            if (currentLevel.get(i).left != null) {
                nextLevel.add(currentLevel.get(i).left);
            }
            if (currentLevel.get(i).right != null) {
                nextLevel.add(currentLevel.get(i).right);
            }
        }

        result.add(currentLevelInteger);
        zigzagLevelOrderHelper(nextLevel, result, !leftToRight);
    }
}
