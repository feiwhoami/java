/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...],
 * find the minimum number of conference rooms required.
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.util.Interval;

public class LeetCode253MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {

        if (null == intervals || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
        endTimes.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.add(intervals[i].end);
        }
        return endTimes.size();
    }
}
