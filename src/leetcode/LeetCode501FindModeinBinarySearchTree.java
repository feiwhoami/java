/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode501FindModeinBinarySearchTree {

    private int maxCount = 0;
    private int count = 1;
    private Integer prev = null;

    public int[] findMode(TreeNode root) {
        if (null == root) {
            return new int[0];
        }

        List<Integer> resultList = new ArrayList<>();
        findModeHelper(root, resultList);

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    private void findModeHelper(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }

        findModeHelper(root.left, result);

        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        prev = root.val;

        findModeHelper(root.right, result);
    }

}
