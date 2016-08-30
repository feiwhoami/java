/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
package leetcode;

import java.util.HashSet;
import java.util.Iterator;

public class LeetCode260SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        HashSet<Integer> hash = new HashSet<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                hash.remove(nums[i]);
            } else {
                hash.add(nums[i]);
            }
        }

        Iterator<Integer> iter = hash.iterator();

        result[0] = iter.next();
        result[1] = iter.next();

        return result;
    }
}
