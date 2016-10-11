/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * Subscribe to see which companies asked this question
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode095UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        result = generateTreesHelper(1, n);
        return result;
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> left = generateTreesHelper(start, i - 1);
            List<TreeNode> right = generateTreesHelper(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {

                    TreeNode root = new TreeNode(i);

                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }

}
