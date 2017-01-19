/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
package leetcode;

import java.util.TreeSet;

public class LeetCode220ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (null == nums || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        int i = 0;
        for (; i <= k && i < nums.length; i++) {
            if ((treeSet.floor(nums[i]) != null && Long.valueOf(treeSet.floor(nums[i]) + t) >= nums[i])
                    || (treeSet.ceiling(nums[i]) != null) && treeSet.ceiling(nums[i]) <= Long.valueOf(nums[i] + t)) {
                return true;
            }
            treeSet.add(nums[i]);
        }

        if (i == nums.length) {
            return false;
        }

        for (int j = 0; i < nums.length; i++, j++) {
            treeSet.remove(nums[j]);
            if ((treeSet.floor(nums[i]) != null && Long.valueOf(treeSet.floor(nums[i]) + t) >= nums[i])
                    || (treeSet.ceiling(nums[i]) != null) && treeSet.ceiling(nums[i]) <= Long.valueOf(nums[i] + t)) {
                return true;
            }
            treeSet.add(nums[i]);
        }

        return false;
    }
}
