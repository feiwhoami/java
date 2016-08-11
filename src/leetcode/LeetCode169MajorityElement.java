/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

package leetcode;

import java.util.HashMap;

public class LeetCode169MajorityElement {

    public int majorityElement(int[] nums) {

        int threshold = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (null == map.get(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            if (map.get(nums[i]) > threshold) {
                return nums[i];
            }
        }
        return 0;
    }
}
