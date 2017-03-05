/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.util.Interval;

public class LeetCode056MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (null == intervals || intervals.isEmpty()) {
            return result;
        }

        int n = intervals.size();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = intervals.get(i).start;
            right[i] = intervals.get(i).end;
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            Interval newInterval = new Interval();
            newInterval.start = left[i++];
            while (i < n && j < n && left[i] <= right[j]) {
                i++;
                j++;
            }
            newInterval.end = right[j++];
            result.add(newInterval);
        }
        return result;
    }
}
