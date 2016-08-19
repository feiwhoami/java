/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode107BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> currentLevel = new ArrayList<>();

        if (null == root) {
            return result;
        }
        currentLevel.add(root);

        levelOrderBottomHelper(currentLevel, result);

        Collections.reverse(result);

        return result;
    }

    private void levelOrderBottomHelper(List<TreeNode> currentLevel, List<List<Integer>> result) {

        if (null == currentLevel || currentLevel.isEmpty()) {
            return;
        }

        List<Integer> currentLevelInteger = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        for (int i = 0; i < currentLevel.size(); i++) {
            if (null != currentLevel.get(i)) {
                currentLevelInteger.add(currentLevel.get(i).val);
            }
            if (null != currentLevel.get(i).left) {
                nextLevel.add(currentLevel.get(i).left);
            }
            if (null != currentLevel.get(i).right) {
                nextLevel.add(currentLevel.get(i).right);
            }
        }

        result.add(currentLevelInteger);
        levelOrderBottomHelper(nextLevel, result);
    }
}
