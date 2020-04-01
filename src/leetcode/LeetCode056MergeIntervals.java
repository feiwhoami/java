/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
package leetcode;

import leetcode.util.Interval;

import java.util.*;

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

    public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (pre.end < curr.start) {
                result.add(pre);
                pre = curr;
            } else {
                pre.end = Math.max(pre.end, curr.end);
            }
        }
        result.add(pre);
        return result;
    }

    public int[][] merge3(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        }

        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] tail = result.get(result.size() - 1);
            int[] curr = intervals[i];
            if (tail[1] >= curr[0]) {
                tail[1] = Math.max(tail[1], curr[1]);
            } else {
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
