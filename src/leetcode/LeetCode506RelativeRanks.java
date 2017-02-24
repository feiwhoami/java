/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode506RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {

        String[] result = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int index = map.get(nums[i]);
            if (i == nums.length - 1) {
                result[index] = "Gold Medal";
            } else if (i == nums.length - 2) {
                result[index] = "Silver Medal";
            } else if (i == nums.length - 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = Integer.toString(nums.length - i);
            }
        }

        return result;
    }
}
