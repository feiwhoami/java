/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
package leetcode;

public class LeetCode080RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int last = 0;
        int hasFound = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[last] != nums[i]) {
                last++;
                nums[last] = nums[i];
                hasFound = 1;
            } else {
                if (hasFound == 2) {
                    continue;
                } else if (hasFound == 1) {
                    last++;
                    nums[last] = nums[i];
                    hasFound = 2;
                } else if (hasFound == 0) {
                    hasFound = 1;
                }
            }
        }

        return last + 1;
    }
}
