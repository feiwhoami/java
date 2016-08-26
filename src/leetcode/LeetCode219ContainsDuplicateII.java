/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
package leetcode;

import java.util.HashSet;

public class LeetCode219ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> hash = new HashSet<>();

        int i;
        for (i = 0; i < k + 1 && i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                return true;
            }
            hash.add(nums[i]);
        }

        if (i == nums.length - 1) {
            return false;
        }

        for (int j = 0; i < nums.length; i++, j++) {
            hash.remove(nums[j]);
            if (hash.contains(nums[i])) {
                return true;
            }
            hash.add(nums[i]);
        }

        return false;
    }
}
