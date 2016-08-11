/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
package leetcode;

import java.util.HashSet;

public class LeetCode217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                return true;
            }
            hash.add(nums[i]);
        }

        return false;
    }
}
