/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> hash = new HashSet<Integer>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {

            if (!hash.isEmpty() && hash.contains(nums[i])) {

                int start = nums[i] - 1;
                int end = nums[i] + 1;

                while (!hash.isEmpty() && hash.contains(start)) {
                    hash.remove(start);
                    start--;
                }
                while (!hash.isEmpty() && hash.contains(end)) {
                    hash.remove(end);
                    end++;
                }

                if (end - start - 1 > max) {
                    max = end - start - 1;
                }
            }
        }
        return max;
    }
}
