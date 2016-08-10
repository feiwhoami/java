/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */

package leetcode;

public class LeetCode026RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int last = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[last]) {
                last++;
                nums[last] = nums[i];
            }
        }

        return last + 1;
    }

}
