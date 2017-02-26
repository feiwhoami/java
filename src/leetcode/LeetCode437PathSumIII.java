/**
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode437PathSumIII {

    private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        List<Integer> currSum = new ArrayList<>();
        pathSumHelper(root, sum, currSum);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> currSum) {
        if (null == root) {
            return;
        }

        List<Integer> newCurrSum = new ArrayList<>(currSum);

        newCurrSum.add(0);
        for (int i = 0; i < newCurrSum.size(); i++) {
            int tmp = newCurrSum.get(i) + root.val;
            if (tmp == sum) {
                result++;
            }
            newCurrSum.set(i, tmp);
        }

        pathSumHelper(root.left, sum, newCurrSum);
        pathSumHelper(root.right, sum, newCurrSum);
    }
}
