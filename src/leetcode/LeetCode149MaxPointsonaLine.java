/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.Point;

public class LeetCode149MaxPointsonaLine {

    public int maxPoints(Point[] points) {

        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 1;

        for (int i = 0; i < points.length; i++) {

            Map<Double, Integer> map = new HashMap<>();
            int same = 0;
            int localMax = 1;

            for (int j = 0; j < points.length; j++) {

                if (i == j) {
                    continue;
                }

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                    continue;
                }

                double slope;
                if (points[i].y == points[j].y) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = (double) (points[i].x - points[j].x) / (points[i].y - points[j].y);
                }

                if (map.get(slope) != null) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }

            for (Integer val : map.values()) {
                localMax = Math.max(val, localMax);
            }

            localMax = localMax + same;
            max = Math.max(localMax, max);
        }
        return max;
    }
}
