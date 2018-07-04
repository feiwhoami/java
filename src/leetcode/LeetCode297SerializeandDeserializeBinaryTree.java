/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import leetcode.util.TreeNode;

public class LeetCode297SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();

        serializeHelper(root, result);

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(" ")));
        TreeNode root = deserializeHelper(nodes);

        return root;
    }

    private void serializeHelper(TreeNode root, StringBuilder result) {
        if (root != null) {
            result.append(root.val).append(" ");
            serializeHelper(root.left, result);
            serializeHelper(root.right, result);
        } else {
            result.append("# ");
        }
    }

    private TreeNode deserializeHelper(Deque<String> nodes) {
        String val = nodes.pollFirst();
        if (val.equalsIgnoreCase("#")) {
            return null;
        } else {
            TreeNode curr = new TreeNode(Integer.valueOf(val));
            curr.left = deserializeHelper(nodes);
            curr.right = deserializeHelper(nodes);
            return curr;
        }
    }
}
