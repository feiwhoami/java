/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode447NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int distance = getDistance(points[i], points[j]);
                if (map.get(distance) == null) {
                    map.put(distance, 1);
                } else {
                    map.put(distance, map.get(distance) + 1);
                }
            }

            for (int val : map.values()) {
                result = result + val * (val - 1);
            }
            map.clear();
        }

        return result;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }
}
