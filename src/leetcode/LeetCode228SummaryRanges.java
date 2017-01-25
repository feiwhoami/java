/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] > nums[i] + 1) {
                int end = i;
                StringBuilder sb = new StringBuilder();
                if (start == end) {
                    sb.append(nums[start]);
                } else {
                    sb.append(nums[start]);
                    sb.append("->");
                    sb.append(nums[end]);
                }
                result.add(sb.toString());
                start = i + 1;
            }
        }

        return result;
    }
}
