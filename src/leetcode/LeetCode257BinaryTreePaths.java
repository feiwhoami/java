/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class LeetCode257BinaryTreePaths {

    /**
     * Solution 1
     */
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (null == root) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        binaryTreePathsHelper(result, sb.toString(), root);

        return result;
    }

    private void binaryTreePathsHelper(List<String> result, String current, TreeNode root) {

        if (null == root.left && null == root.right) {
            result.add(current);
            return;
        }

        if (null != root.left) {
            StringBuilder sb = new StringBuilder(current);
            sb.append("->");
            sb.append(root.left.val);
            binaryTreePathsHelper(result, sb.toString(), root.left);
        }

        if (null != root.right) {
            StringBuilder sb = new StringBuilder(current);
            sb.append("->");
            sb.append(root.right.val);
            binaryTreePathsHelper(result, sb.toString(), root.right);
        }

        return;
    }

    /**
     * Solution 2
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        binaryTreePathsHelper2(root, "", result);
        return result;
    }

    private void binaryTreePathsHelper2(TreeNode currNode, String currPath, List<String> result) {
        if (null == currNode) {
            return;
        }

        if (null == currNode.left && null == currNode.right) {
            String newPath = currPath + currNode.val;
            result.add(newPath);
            return;
        }

        String newPath = currPath + currNode.val + "->";
        binaryTreePathsHelper2(currNode.left, newPath, result);
        binaryTreePathsHelper2(currNode.right, newPath, result);
    }

}
