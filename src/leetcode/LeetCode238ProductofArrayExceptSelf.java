/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
package leetcode;

public class LeetCode238ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        if (0 == length) {
            return null;
        }

        int[] result = new int[length];
        int[] productFromBegin = new int[length];
        int[] productFromEnd = new int[length];

        productFromBegin[0] = 1;
        for (int i = 1; i < length; i++) {
            productFromBegin[i] = productFromBegin[i - 1] * nums[i - 1];
        }

        productFromEnd[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            productFromEnd[i] = productFromEnd[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = productFromBegin[i] * productFromEnd[i];
        }

        return result;
    }
}
