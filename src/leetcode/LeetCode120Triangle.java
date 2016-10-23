/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
package leetcode;

import java.util.List;

public class LeetCode120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (null == triangle) {
            return 0;
        }

        int size = triangle.size();
        int[] min = new int[triangle.get(size - 1).size()];

        for (int i = size - 1; i >= 0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == size - 1) {
                    min[j] = triangle.get(i).get(j);
                } else {
                    min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
                }
            }
        }

        return min[0];
    }
}
