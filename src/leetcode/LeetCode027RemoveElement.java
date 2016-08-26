/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
package leetcode;

public class LeetCode027RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int first = 0, second = 0;

        while (first < nums.length && second < nums.length) {

            if (nums[first] != val && nums[second] != val) {
                first++;
                second++;
            } else if (nums[first] == val && nums[second] != val) {
                int tmp = nums[first];
                nums[first] = nums[second];
                nums[second] = tmp;
                first++;
                second++;
            } else if (nums[second] == val) {
                second++;
            }
        }

        return first;
    }
}
