/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
package leetcode;

public class LeetCode031NextPermutation {

    public void nextPermutation(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return;
        }

        int i = length - 1;

        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
            i--;
        }

        if (i == 0) {
            reverse(nums, 0, length - 1);
            return;
        }

        i--;
        int j = length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

        reverse(nums, i + 1, length - 1);

        return;
    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }

        return;
    }
}
