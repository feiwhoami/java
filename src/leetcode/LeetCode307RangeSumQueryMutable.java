/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
package leetcode;

import leetcode.util.SegmentTreeNode;

public class LeetCode307RangeSumQueryMutable {

    private SegmentTreeNode root;

    public LeetCode307RangeSumQueryMutable(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        updateHelper(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(this.root, i, j);
    }

    private void updateHelper(SegmentTreeNode node, int i, int val) {
        if (node.start == i && node.end == i) {
            node.sum = val;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) {
            updateHelper(node.left, i, val);
        } else {
            updateHelper(node.right, i, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    private int sumRangeHelper(SegmentTreeNode node, int i, int j) {
        if (i == node.start && j == node.end) {
            return node.sum;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (j <= mid) {
            return sumRangeHelper(node.left, i, j);
        } else if (i > mid) {
            return sumRangeHelper(node.right, i, j);
        } else {
            return sumRangeHelper(node.left, i, mid) + sumRangeHelper(node.right, mid + 1, j);
        }
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        } else {
            SegmentTreeNode node = new SegmentTreeNode(low, high);
            if (low == high) {
                node.sum = nums[low];
            } else {
                int mid = low + (high - low) / 2;
                node.left = buildSegmentTree(nums, low, mid);
                node.right = buildSegmentTree(nums, mid + 1, high);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }
    }
}
