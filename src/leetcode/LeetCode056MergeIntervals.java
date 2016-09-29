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

        int indexLeft = 0;
        int indexRight = 0;
        while (indexLeft < n && indexRight < n) {
            Interval i = new Interval();

            i.start = left[indexLeft++];
            while (indexLeft < n && indexRight < n && left[indexLeft] <= right[indexRight]) {
                indexLeft++;
                indexRight++;
            }
            i.end = right[indexRight++];
            result.add(i);
        }

        return result;
    }
}
