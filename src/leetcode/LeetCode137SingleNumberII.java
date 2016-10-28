/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode137SingleNumberII {

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            if (pair.getValue() == 1) {
                return pair.getKey();
            }
        }

        return -1;
    }
}
