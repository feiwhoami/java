/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.Interval;

public class LeetCode057InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        if (null == intervals || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        int i;
        for (i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
            } else if (intervals.get(i).start > newInterval.end) {
                break;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }

        result.add(newInterval);
        for (; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }

        return result;
    }
}
