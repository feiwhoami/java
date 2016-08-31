/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode347TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        if (0 == nums.length) {
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == map.get(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        List<List<Integer>> bucket = new ArrayList<List<Integer>>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            List<Integer> b = new ArrayList<>();
            bucket.add(b);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getValue() - 1;
            int element = entry.getKey();

            if (null == bucket.get(index)) {
                List<Integer> b = new ArrayList<>();
                b.add(element);
                bucket.add(index, b);
            } else {
                bucket.get(index).add(element);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> b = bucket.get(i);
            int j = 0;

            while (k > 0 && j < b.size()) {
                result.add(b.get(j));
                k--;
                j++;
            }
            if (0 == k) {
                break;
            }
        }

        return result;
    }
}
