/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode229MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();

        if (null == nums || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int third = nums.length / 3;
        int count = 0;

        int i = 0;
        while (i < nums.length && count < 2) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if (!result.contains(nums[i]) && map.get(nums[i]) > third) {
                count++;
                result.add(nums[i]);
            }
            i++;
        }

        return result;
    }

}
