/**
 * Definition for segment tree.
 */
package leetcode.util;

public class SegmentTreeNode {

    public int start;

    public int end;

    public int sum;

    public SegmentTreeNode left;

    public SegmentTreeNode right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }
}
